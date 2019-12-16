package pp2.ifpe.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.UUID;

import javax.mail.MessagingException;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pp2.ifpe.enums.TipoUsuarioEnum;
import pp2.ifpe.model.Usuario;
import pp2.ifpe.model.UsuarioDAO;

@Service
public class UsuarioService {
	

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@Autowired
	private EmailService emailService;
	
	
	public Usuario findUsuarioByEmail(String email) {
		return usuarioDAO.findByEmailIgnoreCase(email);
	}

	public Usuario findByEmail(String email) {
		return usuarioDAO.findByEmailIgnoreCase(email);
	}

	public Optional<Usuario> findById(Integer id) {
		return this.usuarioDAO.findById(id);
	}

	public Usuario findByNome(String nome) {
		return this.usuarioDAO.findByNomeIgnoreCase(nome);
	}

	public void save(Usuario usuario) {
		this.usuarioDAO.save(usuario);
	}
	
	public void criarUsuario(Usuario usuario) throws ServiceException, MessagingException {
		if (this.findUsuarioByEmail(usuario.getEmail()) != null) {
			throw new ServiceException("Já existe um usuário com este e-mail: " + usuario.getEmail());
		}

		if (this.findByNome(usuario.getNome()) != null) {
			throw new ServiceException("Já existe um usuário com este apelido: " + usuario.getNome());
		}

		usuario.setTipoUsuario(TipoUsuarioEnum.PADRAO);
		usuario.setToken(UUID.randomUUID().toString());
		System.out.println(UUID.randomUUID().toString());

		//Criptografando senha antes de insere-la no banco
		String senhaCriptografada;
		try {
			senhaCriptografada = criptografarSenha(usuario.getSenha());
			usuario.setSenha(senhaCriptografada);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		this.save(usuario);
		this.emailService.enviarConfirmacaoDeConta(usuario);
	}
	
       public Usuario efetuarLogin(String email, String senha) throws ServiceException, NoSuchAlgorithmException, UnsupportedEncodingException {
		
		
		String senhaCriptografada = criptografarSenha(senha);
		Usuario usuario = this.usuarioDAO.efetuarLogin(email, senhaCriptografada);
		//Usuario usuario = this.usuarioDAO.efetuarLogin(email, senha);

		if (usuario == null) {
			throw new ServiceException("Login/senha não encontrados");
		}

		if (usuario.getAtivo() == false) {
			throw new ServiceException("Conta desativada");
		}

		return usuario;
	}
	
	
	
	
	
	public String criptografarSenha(String senha)  throws NoSuchAlgorithmException, 
	   UnsupportedEncodingException{
		
	    String senhaCriptografada = null;
		
		MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
		byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));
		 
		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest) {
		  hexString.append(String.format("%02X", 0xFF & b));
		}
		
		senhaCriptografada = hexString.toString();	
		algorithm.reset();
		
		return senhaCriptografada;
		
	}//fim do metodo criptografarSenha
}	
