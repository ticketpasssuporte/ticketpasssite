package pp2.ifpe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pp2.ifpe.model.Ingresso;
import pp2.ifpe.persistence.EventoDAO;
import pp2.ifpe.persistence.IngressoDAO;

@Controller
public class IngressoController {

	@Autowired
	private IngressoDAO ingressoDAO;
	
	@Autowired
	private EventoDAO eventoDAO;
	
	@GetMapping("/ingresso") 
	public String configurarIngresso(Ingresso ingresso){
		return"/configurarIngresso";
	}
	
	@PostMapping("/salvarIngresso")
	public String salvarIngresso(Ingresso ingresso) {
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
