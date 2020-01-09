package pp2.ifpe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pp2.ifpe.model.Evento;
import pp2.ifpe.persistence.EventoDAO;
import pp2.ifpe.service.EventoService;

@Controller
public class EventoController {
	
	@Autowired
	private EventoService eventoService;
	
	@Autowired
	private EventoDAO eventoDAO;
	

	@GetMapping("/evento") 
	public String cadastraEvento(Evento evento) {
		return"/criarEvento";
	}
		
		
	@PostMapping("/salvarEvento")
	public String salvarEvento(Evento evento, BindingResult result, RedirectAttributes redirectAttributes) {
		
		redirectAttributes.addFlashAttribute("message", "Failed");
		redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
		if (result.hasErrors()) {
			return cadastraEvento(evento);
		}
		redirectAttributes.addFlashAttribute("message", "Cadastro realizado com sucesso");
		redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		/*try {
			evento.setFoto_evento(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} */
		
		this.eventoDAO.save(evento);
		return "redirect:/evento";
	
	}
	
	@GetMapping("/listarEventos")
	public String listarCandidato(Model model) {
		model.addAttribute("lista",eventoService.findAll(Sort.by("nome")));
		return "evento-list";
	}
	
	
	
	/*		
	
	
	
	@PostMapping("/salvarIngresso")
	public String salvarIngresso(Ingresso ingresso) throws ServiceException, MessagingException {
		
/*		try {
			evento.setFoto_evento(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.eventoService.salvarIngresso(ingresso);
		return"redirect:/index";
	}
	*/
	/*@GetMapping("/eventoCadastro")
	public String eventoCadastro(Evento evento) {
		return"/eventoCadastro";
	}*/
	@GetMapping("/lote")
	public String lote(Evento evento) {
		return"/lote";
	}
//	@GetMapping("")
//	public String editarEvento(Integer id) {
//		this.evenService.editarEvento();
//		return"";
//	}
//	
//	@GetMapping("/removerEvento")
//	public String removerEventos(Integer id){
//		this.evenService.editarEvento();
//		return"/";
//	}
//	

}
