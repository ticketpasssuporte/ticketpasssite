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
	
	@GetMapping("/cadastraEvento")
	public String cadastraEvento(Evento evento) {
		return"redirect:/";
	}
	
	@PostMapping("/salvarEvento")
	public String salvarEvento(Evento evento) {
		this.evenService.salvarEvento(evento);
		return"redirect:/";
	}
	
//	@GetMapping("")
//	public String editarEvento(Integer id) {
//		this.evenService.editarEvento();
//		return"";
//	}
	
//	@GetMapping("/removerEvento")
//	public String removerEventos(Integer id){
//		this.evenService.editarEvento();
////		return"/";
//	}
	
}
