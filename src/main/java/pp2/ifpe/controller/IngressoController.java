package pp2.ifpe.controller;


import javax.mail.MessagingException;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pp2.ifpe.model.Evento;
import pp2.ifpe.model.Ingresso;
import pp2.ifpe.persistence.EventoDAO;
import pp2.ifpe.persistence.IngressoDAO;
import pp2.ifpe.service.IngressoService;

@Controller
public class IngressoController {

	@Autowired
	private IngressoDAO ingressoDAO;
	
	@Autowired
	private IngressoService ingressoService;
	
	@Autowired
	private EventoDAO eventoDAO;
	
	Integer idevento;
	
	
	
	@GetMapping("/ingresso") 
	public ModelAndView configurarIngresso(Model model, Ingresso ingresso, @RequestParam("id") Integer id){
		ModelAndView mv= new ModelAndView("configurarIngresso");
		this.idevento = id;
		mv.addObject("evento",eventoDAO.findById(id));
		model.addAttribute("listaIng",ingressoDAO.findAll());
	    return mv;
	}
	
	
	@PostMapping("/salvarIngresso")
	public String salvarIngresso(Ingresso ingresso)throws ServiceException, MessagingException {
		Evento evento = eventoDAO.findByCodigo(idevento);
		ingresso.setId(0);
		ingresso.setEvento(evento);
		if(this.ingressoDAO.findByTipo(ingresso.getTipoIngresso()) != null) {
		throw new ServiceException("Já existe Ingresso com desse tipo ");		
		}else{
		this.ingressoDAO.save(ingresso);
		return "redirect:/listarMeusEventos";
	}
}
	
	
	private Object ingressoDAO(String tipoIngresso) {
		// TODO Auto-generated method stub
		return null;
	}


	@GetMapping("editarIngresso")
	public String editarIngresso(Integer id, Model model) {
	model.addAttribute("ingresso", this.ingressoService.findById(id));

		return "/configurarIngresso";
	}
	
	
	
}
