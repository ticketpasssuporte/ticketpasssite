package pp2.ifpe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {
		
	
	
	
	
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
	
	@GetMapping("/pagEvento")
	public String pagEvento() {
		return "pagEvento";
	}
	
	@GetMapping("/carrinho")
	public String carrinho() {
		return "carrinho";
	}


}
