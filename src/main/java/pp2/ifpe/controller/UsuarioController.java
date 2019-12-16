package pp2.ifpe.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pp2.ifpe.model.Email;
import pp2.ifpe.model.Usuario;
import pp2.ifpe.service.EmailService;
import pp2.ifpe.service.UsuarioService;

@Controller
public class UsuarioController {

	
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private EmailService emailService;
	
	/*
	 * Cadastro
	 */
	@GetMapping("/cadastro")
	public ModelAndView exibirTelaCadastro() {
		ModelAndView mv = new ModelAndView("/cadastro");
		mv.addObject("usuario", new Usuario());
		return mv;
	}

	@PostMapping("/cadastro")
	public String salvarUsuario(@Valid @ModelAttribute Usuario usuario, Errors errors, RedirectAttributes ra) {
		if (errors.hasErrors()) {
			ra.addFlashAttribute("mensagemErro", "Não foi possível criar usuário: " + errors.getFieldErrors());

			return "redirect:/cadastro";
		} else {
			try {
				this.usuarioService.criarUsuario(usuario);
				ra.addFlashAttribute("mensagem", "Conta criada com sucesso!");
			} catch (ServiceException | MessagingException e) {
				ra.addFlashAttribute("mensagemErro", "Não foi possível criar usuário: " + e.getMessage());

				return "redirect:/cadastro";
			}
		}

		ra.addFlashAttribute("contaCriada", true);
		return "redirect:/ativarConta";
	}

	//---------------------------------------//
	
	/*
	 * Login / Logout
	 */
	@GetMapping("/login")
	public ModelAndView login(HttpServletRequest request, RedirectAttributes ra) {
		ModelAndView mv = new ModelAndView("/login");
		mv.addObject("usuario", new Usuario());

		if (request.getAttribute("acessoNegado") != null) {
			boolean acessoNegado = (boolean) request.getAttribute("acessoNegado");
			String retorno = (String) request.getAttribute("retorno");
			if (acessoNegado == true) {
				mv.addObject("acessoNegado", request.getRequestURI());
				mv.addObject("retorno", retorno);
			}
		}

		return mv;
	}
	
	@PostMapping("/login")
	public String efetuarLogin(HttpServletRequest request, @ModelAttribute Usuario usuario,
			@RequestParam(name = "retorno", required = false) String retorno, RedirectAttributes ra,
			HttpSession session) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String redirect = "redirect:/index";
		if (retorno != null) {
			redirect = "redirect:" + retorno;
		}

		Usuario usuarioLogado;
		try {
			usuarioLogado = this.usuarioService.efetuarLogin(usuario.getEmail(), usuario.getSenha());
			session.setAttribute("usuarioLogado", usuarioLogado);
		} catch (ServiceException e) {
			ra.addFlashAttribute("mensagemErro", e.getMessage());

			return "redirect:/login";
		}

		ra.addFlashAttribute("loginEfetuado", true);
		return redirect;
	}
	
	
	
	
	
	/*
	 * Ativar conta
	 */
	// mensagem que o email foi enviado
	@GetMapping("ativar")
	public String ativeSuaConta() {
		return "/ativarConta";
	}

	// Ativar conta no bd
	@GetMapping("/ativarConta")
	public String ativarConta(@RequestParam(name = "token", required = false) String token, RedirectAttributes ra) {

		if (token == "" || token == null) {
			ra.addFlashAttribute("alertErro", "Token de ativação inválido");
			return "redirect:ativar";
		}

		Email email = this.emailService.findByToken(token);

		if (this.emailService.validarVencimento(email)) {
			Usuario usuario = this.usuarioService.findByEmail(email.getEmailDestinatario());
			usuario.setAtivo(true);
			this.usuarioService.save(usuario);
		} else {
			ra.addFlashAttribute("alertErro", "Token de ativação vencido, por favor re-envie o email de ativação");
			return "redirect:ativar";
		}

		ra.addFlashAttribute("alertSucesso", "Conta Ativada com sucesso!");
		return "redirect:/login";
	}
	
}
