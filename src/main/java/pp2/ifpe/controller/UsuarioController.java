package pp2.ifpe.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String salvarusuario(Usuario usuario,@RequestParam(name = "nome") String nome,
			@RequestParam(name = "email") String email,@RequestParam(name = "senha") String senha, RedirectAttributes ra){
		
		Optional<Usuario> verificacaoCad = usuarioDAO.findByEmail(usuario.getEmail());
		
		if(verificacaoCad != null) {
		ra.addAttribute("mensagemErrro", "Email Já existe em uma de nossas contas");
		return "redirect:/salvarUsuario";
		}else {
		usuario.setSenha(Functions.getSHA256(usuario.getSenha()));
		//usuario.setToken(Functions.getSHA256(usuario.getToken()));
		
		this.usuarioDAO.save(usuario);
		return "redirect:/login";
		}	
	}
	
    //-----Verificando se existe o email e senha inseridos------
	
	@PostMapping("/realizarLogin")
	public String efetuarLogin(Usuario usuario, Model model,HttpSession sessao) throws NoSuchAlgorithmException {
		
		
		usuario.setSenha(Functions.getSHA256(usuario.getSenha()));
		Usuario usuarioConsultado = usuarioDAO.buscalogin(usuario.getEmail(),usuario.getSenha());
		
		if(usuarioConsultado == null) {
			model.addAttribute("mensagem", "Usuario e senha invalido");	
		}else {
			sessao.setAttribute("usuariologado", usuarioConsultado);

			return "index";
		}
		
		return null;

	}	
}
