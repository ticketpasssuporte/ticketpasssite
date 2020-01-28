package pp2.ifpe.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

@Controller
public class IngressoController {

	@Autowired
	private IngressoDAO ingressoDAO;
	
	@Autowired
	private EventoDAO eventoDAO;
	
	Integer idevento;
	
	@GetMapping("/ingresso") 
	public ModelAndView configurarIngresso(Ingresso ingresso, @RequestParam("id") Integer id){
		ModelAndView mv= new ModelAndView("configurarIngresso");
		this.idevento = id;
		mv.addObject("evento",eventoDAO.findById(id));
	    return mv;
	}
	
	@PostMapping("/salvarIngresso")
	public String salvarIngresso(Ingresso ingresso) {
		Evento evento = eventoDAO.findByCodigo(idevento);
		ingresso.setEvento(evento);
		this.ingressoDAO.save(ingresso);
		return "redirect:/listarMeusEventos";
	
	}

	
	
	@GetMapping("editarIngresso")
	public String editarIngresso(Integer id, Model model) {
	model.addAttribute("ingresso", this.ingressoDAO.findById(id));

		return "/configurarIngresso";
	}
	
	@GetMapping("/removerIngresso")
	public String removerIngresso(Integer id) {
		this.ingressoDAO.deleteById(id);
		return "redirect:/listarMeusEventos";
	}

}
