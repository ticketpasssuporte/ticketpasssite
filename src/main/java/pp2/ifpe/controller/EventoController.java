package pp2.ifpe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pp2.ifpe.model.Evento;
import pp2.ifpe.service.EventoService;

@Controller
public class EventoController {
	
	@Autowired
	private EventoService evenService;
	
	@GetMapping("/cadEvento")
	public String cadEvento(Evento evento) {
		return"redirect:/";
	}
	
	@PostMapping("/cadastraEvento")
	public String cadastrandoEvento(Evento evento) {
		this.evenService.salvarEvento(evento);
		return"redirect:/";
	}
	
}
