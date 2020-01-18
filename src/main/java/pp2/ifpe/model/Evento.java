package pp2.ifpe.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;


@Entity
public class Evento {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	@Column(length = 50)
	private String nomeEvento;
	private Boolean status;
	@Column(length = 255)
	private String endereco;
	@Column(length = 150)
	private String desc_evento;
	@Column(length = 30)
	private String nomeOrganizador;
	@Column(length = 500)
	private String desc_org;
	@Column
	private String categoria;
	@ManyToOne
	private Usuario usuario;
	@ManyToOne
	private Ingresso ingresso;

		
	private String fotoevento; 
	

	public String getNomeOrganizador() {
		return nomeOrganizador;
	}


	public void setNomeOrganizador(String nomeOrganizador) {
		this.nomeOrganizador = nomeOrganizador;
	}

	
	public String getCategoria() {
		return categoria;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getNomeEvento() {
		return nomeEvento;
	}



	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}
	
	
	public Boolean getStatus() {
		return status;
	}



	public void setStatus(Boolean status) {
		this.status = status;
	}

	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	
	public String getDesc_evento() {
		return desc_evento;
	}



	public void setDesc_evento(String desc_evento) {
		this.desc_evento = desc_evento;
	}



	public String getDesc_org() {
		return desc_org;
	}

	public void setDesc_org(String desc_org) {
		this.desc_org = desc_org;
	}


	public Ingresso getIngresso() {
		return ingresso;
	}


	public void setIngresso(Ingresso ingresso) {
		this.ingresso = ingresso;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public String getFotoevento() {
		return fotoevento;
	}


	public void setFotoevento(String fotoevento) {
		this.fotoevento = fotoevento;
	}





	@Override
	public String toString() {
		return "Evento [id=" + id + ", nomeEvento=" + nomeEvento + ", status=" + status + ", endereco=" + endereco
				+ ", desc_evento=" + desc_evento + ", nomeOrganizador=" + nomeOrganizador + ", desc_org=" + desc_org
				+ ", categoria=" + categoria + ", usuario=" + usuario + ", ingresso=" + ingresso + ", fotoevento="
				+ fotoevento + "]";
	}


	public Evento(Integer id, @NotNull String nomeEvento, Boolean status, String endereco, String desc_evento,
			String nomeOrganizador, String desc_org, String categoria, Usuario usuario, Ingresso ingresso,
			String fotoevento) {
		super();
		this.id = id;
		this.nomeEvento = nomeEvento;
		this.status = status;
		this.endereco = endereco;
		this.desc_evento = desc_evento;
		this.nomeOrganizador = nomeOrganizador;
		this.desc_org = desc_org;
		this.categoria = categoria;
		this.usuario = usuario;
		this.ingresso = ingresso;
		this.fotoevento = fotoevento;

	}


	public Evento() {
		super();
		// TODO Auto-generated constructor stub
	}


/*	public Categoria getCategoria() {
		return categoria;
	}



	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}*/

	
	

}
