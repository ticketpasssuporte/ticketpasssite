package pp2.ifpe.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pp2.ifpe.service.CategoriaService;
import pp2.ifpe.service.EventoService;

@Controller

public class PesquisaCategoria {
	
	@Autowired
	private EventoService eventoService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/categoria2")
	public String eventosCategoria(@RequestParam("id")Integer id, HttpSession session, Model model) throws Exception {
		model.addAttribute("listaCat",categoriaService.listaCategoria());
		model.addAttribute("lista", eventoService.listEventoCategoria(id));
		return "listarCategoria2";
	}
}
