package pp2.ifpe.controller;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pp2.ifpe.exception.ServiceException;
import pp2.ifpe.model.Evento;
import pp2.ifpe.service.EventoService;

@Controller
public class EventoController {
	
	@Autowired
	private EventoService eventoService;
	

	@GetMapping("/evento") 
	public String cadastraEvento(Evento evento) {
	
		return"/criarEvento";
	}
	
	/*@GetMapping("/eventoCadastro")
	public String eventoCadastro(Evento evento) {
		return"/eventoCadastro";
	}*/
	@GetMapping("/lote")
	public String lote(Evento evento) {
		return"/lote";
	}
	
	
	@PostMapping("/salvarEvento")
	public String salvarEvento(Evento evento) throws ServiceException, MessagingException {
		
/*		try {
			evento.setFoto_evento(file.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
		this.eventoService.salvarEvento(evento);
		return"redirect:/";
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
