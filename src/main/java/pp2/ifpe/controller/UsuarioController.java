package pp2.ifpe.controller;

import java.security.NoSuchAlgorithmException;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import pp2.ifpe.model.Usuario;
import pp2.ifpe.model.UsuarioDAO;
import pp2.ifpe.util.Functions;

@Controller
public class UsuarioController {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@GetMapping("/login")
	public String login(Usuario usuario, Model model) {
		model.addAttribute("usuario", new Usuario());
		return "login";
	}
	//------------Salvando cadastros no banco-------------
	
	@PostMapping("/salvarUsuario")
	public String salvarusuario(Usuario usuario) {
		usuario.setSenha(Functions.getSHA256(usuario.getSenha()));
		//usuario.setToken(Functions.getSHA256(usuario.getToken()));
		this.usuarioDAO.save(usuario);
		return "redirect:/login";
	}
	
    //-----Verificando se existe o email e senha inseridos------
	
	@PostMapping("/realizarlogin")
	public String efetuarLogin(Usuario usuario, Model model,HttpSession sessao) throws NoSuchAlgorithmException {
		
		
		usuario.setSenha(Functions.getSHA256(usuario.getSenha()));
		Usuario usuarioConsultado = usuarioDAO.buscalogin(usuario.getEmail(),usuario.getSenha());
		
		if(usuarioConsultado == null) {
			model.addAttribute("mensagem", "Email ou senha invalido");	
		}else {
			sessao.setAttribute("usuariologado", usuarioConsultado);

			return "index";
		}
		
		return "login";

	}	
}
