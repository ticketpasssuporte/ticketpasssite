package pp2.ifpe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TesteController {

	@GetMapping("/index")
	public String index() {
		return "index";
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/carrinho")
	public String compras() {
		return "carrinhoDeCompras";
	}
	
	@GetMapping("/confirmouConta")
	public String confirmou() {
		return "confirmouConta";
	}
	
	@GetMapping("/ativarConta")
	public String ativar() {
		return "ativacaoConta";
	}
	
	@GetMapping("/quemSomos")
	public String sobre() {
		return "quemSomos";
	}
	
	@GetMapping("/ingressos")
	public String ingressos() {
		return "ingressos";
	}
}
