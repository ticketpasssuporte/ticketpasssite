package pp2.ifpe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {
		
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	
	@GetMapping("/pag")
	public String pag() {
		
		return "page15";
	}
	
	
	@GetMapping("/home")
	public String home() {
		return "home";
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
