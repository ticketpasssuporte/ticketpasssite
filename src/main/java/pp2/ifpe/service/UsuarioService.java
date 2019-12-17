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
	
	public void recuperarSenha(String email) {
		
		Usuario usuario = this.usuarioDAO.findByEmailIgnoreCase(email);
		
		if((usuario!= null)) {
			
			
			//gerando senha com 8 letras				
			String senha = GeradorDeSenhaAleatorio(8);
			String senhaCriptografada;
			try {
				
				senhaCriptografada = criptografarSenha(senha);
				usuario.setSenha(senhaCriptografada);
				//usuario.setSenha(senha);
				this.usuarioDAO.save(usuario);
				
				
			} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				this.emailService.enviarRecuperacaoDeSenha(email, usuario.getNome(), senha);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} //fim do if
		
	}//fim do metodo recuperarSenha
	
	public String GeradorDeSenhaAleatorio(int qtdDeLetras){
	     java.util.Random r = new java.util.Random();
	     char[] goodChar = { 'a', 'b', 'c', 'd', 'e', 'f', 'g',
	         'h','i', 'j', 'k','l', 'm', 'n','o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'x','w',
	         'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I','J', 'K','L',
	         'M', 'N','O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z','1',
	         '2', '3', '4', '5', '6', '7', '8', '9'};
	    StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < qtdDeLetras; i++) {
	      sb.append(goodChar[r.nextInt(goodChar.length)]);
	    }
	    return sb.toString();
	  }//fim do metodo GeradorDeSenhaAleatorio
	
}	
