package pp2.ifpe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {
		
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	@GetMapping("/home")
	public String home() {
		return "home";
	}

	
	@GetMapping("/quemSomos")
	public String quemSomos() {
		return "quemSomos";
	}
		
	
	@GetMapping("/confirmouConta")
    public String confirmou() {
		return "confirmouConta";
	}
	
	@GetMapping("/esqueciSenha")
    public String esqueceuSenha() {
		return "esqueceuSenha";
	}
	
	
	@GetMapping("/redefinicaoSenha")
    public String redefinicao() {
		return "redefinirSenha";
	}
	
	@GetMapping("/criarEvento")
	public String criarEvento() {
	return "criarEvento";	
	}
}
