package pp2.ifpe.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Email {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_email")
	private Integer id;
	private String nomeRemetente;
	private String emailRemetente;
	private String nomeDestiantario;
	private String emailDestinatario;
	private String assunto;

	@Embedded
	private EmailMensagem mensagem;

	private String token;
	private LocalDate validade;

	public Email() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeRemetente() {
		return nomeRemetente;
	}

	public void setNomeRemetente(String nomeRemetente) {
		this.nomeRemetente = nomeRemetente;
	}

	public String getEmailRemetente() {
		return emailRemetente;
	}

	public void setEmailRemetente(String emailRemetente) {
		this.emailRemetente = emailRemetente;
	}

	public String getNomeDestiantario() {
		return nomeDestiantario;
	}

	public void setNomeDestiantario(String nomeDestiantario) {
		this.nomeDestiantario = nomeDestiantario;
	}

	public String getEmailDestinatario() {
		return emailDestinatario;
	}

	public void setEmailDestinatario(String emailDestinatario) {
		this.emailDestinatario = emailDestinatario;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public EmailMensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(EmailMensagem mensagem) {
		this.mensagem = mensagem;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public LocalDate getValidade() {
		return validade;
	}

	public void setValidade(LocalDate validade) {
		this.validade = validade;
	}
}
