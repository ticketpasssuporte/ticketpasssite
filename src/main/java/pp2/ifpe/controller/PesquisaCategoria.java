package pp2.ifpe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import pp2.ifpe.model.Evento;
import pp2.ifpe.service.EventoService;

@Controller
@RequestMapping("/pesquisar")
public class PesquisaCategoria {
	
	@Autowired
	private EventoService eventoService;
	
	@GetMapping("/categoria/{id}")
	public String eventosCategoria(Model model, @PathVariable("id")Integer id) {
		List<Evento> eventos = eventoService.listEventoCategoria(id);
		return "listarCategoria";
	}
}
