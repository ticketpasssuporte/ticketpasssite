package pp2.ifpe.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pp2.ifpe.model.Categoria;
import pp2.ifpe.model.Evento;
import pp2.ifpe.model.Ingresso;
import pp2.ifpe.model.Usuario;
import pp2.ifpe.persistence.EventoDAO;
import pp2.ifpe.persistence.IngressoDAO;
import pp2.ifpe.persistence.UsuarioDAO;
import pp2.ifpe.service.CategoriaService;
import pp2.ifpe.service.EventoService;
import pp2.ifpe.service.IngressoService;

@Controller
public class EventoController {
	
	// Caminho da pasta onde ficam as imagens do evento
	private static String caminhoImagens ="/home/ticketpass/ImagemEvento/";
	
	@Autowired
	private EventoDAO eventoDAO;
	
	@Autowired
	private IngressoDAO ingressoDAO;
	
	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private EventoService eventoService;
	
	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private IngressoService ingressoService;
	
		
	
	@GetMapping("/evento") 
	public String cadastraEvento(Evento evento, Model model) {
		List<Categoria> categoria1 = categoriaService.listaCategoria();
		model.addAttribute("categoria", categoria1);
		return"criarEvento";
	}
		
		//Metodo para fazer upload da imagem do evento adicionado na hora de salvar, o nome da imagem Ã© salva com o id do evento
	@PostMapping("/salvarEvento")
	public String salvarEvento(@Valid Evento evento, BindingResult result, HttpSession session, RedirectAttributes redirectAttributes, @RequestParam("file") MultipartFile arquivo) throws Exception{
		
		if (result.hasErrors()) {
			redirectAttributes.addFlashAttribute("message", "Seu cadastro falhou, tente novamente");
			redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
			return "redirect:/evento";
			
		}
		
		try {
			if(!arquivo.isEmpty()) {
				byte[] bytes = arquivo.getBytes();
				Path caminho = Paths.get(caminhoImagens+String.valueOf(evento.getId())+arquivo.getOriginalFilename());
				Files.write(caminho, bytes);
				
				evento.setFotoevento(String.valueOf(evento.getId())+arquivo.getOriginalFilename());
				this.eventoService.salvar(evento);
				redirectAttributes.addFlashAttribute("message", "Cadastro realizado com sucesso");
				redirectAttributes.addFlashAttribute("alertClass", "alert-success");
			}
			
		} catch (Exception e) {
			
			redirectAttributes.addFlashAttribute("mensagemErro2", "Não foi possível salvar evento: " + e.getMessage());
			return "redirect:/evento";
	}	
		return "redirect:/home";	
	}
	
	@GetMapping("/")
	public String listarEventoIndex(Model model) {
		model.addAttribute("listaCat",categoriaService.listaCategoria());
		model.addAttribute("lista",eventoDAO.findAll());
		return "index";
	}
	
	@GetMapping("/home")
	public String listarEvento(Model model) {
		model.addAttribute("listaCat",categoriaService.listaCategoria());
		model.addAttribute("lista",eventoDAO.findAll());
		return "home";
	}
	
	
	
	@GetMapping("/listarMeusEventos")
	public String listarMeusEventos (Model model, Usuario usuario, HttpSession sessao) {		
		Usuario usuariologado = (Usuario) sessao.getAttribute("usuarioLogado");
		model.addAttribute("lista",eventoDAO.findAllByUsuario(usuariologado.getId()));
		return "listarEventos";
	}
	
	
	
	@GetMapping("editarEvento")
	public String editarEvento(Integer id, Model model) {
	model.addAttribute("evento", this.eventoService.findById(id));
		return "criarEvento";
	}
	
	
	@GetMapping("/pagEvento")
	public String descricaoEvento2(@RequestParam("id") Integer codigo,HttpSession session,Model model, RedirectAttributes ra ) throws Exception {
		try {
		Evento evento = this.eventoService.findByIdEvento(codigo);
		Ingresso ingresso = this.ingressoService.findByIdIngresso(codigo);
		model.addAttribute("evento", evento);
		model.addAttribute("ingresso", ingresso);
		} catch(Exception e) {
			ra.addFlashAttribute("mensagemErro3", "Não foi possível exibir evento: " + e.getMessage());
			return"redirect:/home";
		}
		return "descEvento";
	}	

	

    @PostMapping("/pesquisar")
	public ModelAndView pesquisar(@RequestParam("nomePesquisa") String nomePesquisa) {
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("lista", eventoDAO.findEventoByNome(nomePesquisa));
	    modelAndView.addObject("eventoobj", new Evento());
	    return modelAndView;
    }
}

    
    
    
//	
//	
//	@GetMapping("/removerEvento")
//	public String removerEventos(Integer id){
//		this.evenService.editarEvento();
//		return"/";
//	}
//	
    

