package pp2.ifpe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pp2.ifpe.model.Usuario;
import pp2.ifpe.model.UsuarioDAO;
import pp2.ifpe.util.Functions;

@Controller
public class TesteController {
	
	@Autowired
	private UsuarioDAO usuarioDAO;

	@GetMapping("/index")
	public String index() {
		return "index";
	}
	@GetMapping("/login")
	public String login(Usuario usuario) {
		return "login";
	}
	
	@PostMapping("/salvarusuario")
	public String salvarusuario(Usuario usuario){
		usuario.setSenha(Functions.getSHA256(usuario.getSenha()));
		usuario.setToken(Functions.getSHA256(usuario.getToken()));
		this.usuarioDAO.save(usuario);
		return "redirect:/login";
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
