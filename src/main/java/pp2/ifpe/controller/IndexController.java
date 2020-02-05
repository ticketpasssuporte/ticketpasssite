package pp2.ifpe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pp2.ifpe.service.CategoriaService;


@Controller
public class IndexController {
	
	@Autowired
	private CategoriaService categoriaService;
		
	@GetMapping("index.html")
	public String index(Model model) {
		model.addAttribute("listaCat",categoriaService.listaCategoria());
		return "redirect:/home";
	}
	
	
	
	@GetMapping("/quemSomos")
	public String quemSomos() {
		return "quemSomos";
	}
		
	@GetMapping("/trocarSenha")
	public String alterarSenha() {
		return "/trocarSenha";
	}
		
	@GetMapping("/confirmouConta")
    public String confirmou() {
		return "confirmouConta";
	}
	
	
	
	@GetMapping("/eventoCadastro")
    public String eventoCadastro() {
		return "/eventoCadastro";
	}
	
	@GetMapping("/esqueciSenha")
    public String esqueceuSenha() {
		return "esqueceuSenha";
	}
	
	
	@GetMapping("/redefinicaoSenha")
    public String redefinicao() {
		return "redefinirSenha";
	}
	

	
	@GetMapping("/eventoPago")
	public String eventoPago() {
		return "eventoPago";
	}
	
	
	


}
