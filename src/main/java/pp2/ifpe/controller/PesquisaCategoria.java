package pp2.ifpe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pp2.ifpe.model.Evento;
import pp2.ifpe.service.CategoriaService;
import pp2.ifpe.service.EventoService;

@Controller
@RequestMapping("/pesquisar")
public class PesquisaCategoria {
	
	@Autowired
	private EventoService eventoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/categoria")
	public String eventosCategoria(Model model, @RequestParam("id")Integer id) {
		model.addAttribute("listaCat",categoriaService.listaCategoria());
		model.addAttribute("lista", eventoService.listEventoCategoria(id));
		return "listarCategoria";
	}
}
