package pp2.ifpe.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Evento {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(length = 50)
	private String nome;
	@DateTimeFormat(pattern = "MM/dd/yyyy") @FutureOrPresent
	private Date datainicio;
	@Temporal(TemporalType.TIME) @Future
	private String horainicio;
	@Temporal(TemporalType.TIME) @Future
	private String horafim;
	@Column(length = 150)
	private String desc_evento;
	@Column(length = 150)
	private String desc_org;
	@ManyToOne
	private Endereco endereco;
	@ManyToOne
	private Categoria categoria;
	@ManyToOne
	private Usuario usuario;
	@OneToMany
	private Ingresso ingresso;
	@Lob @Column(name = "foto_evento")
	private byte[] foto_evento;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDatainicio() {
		return datainicio;
	}
	public void setDatainicio(Date datainicio) {
		this.datainicio = datainicio;
	}
	public String getHorainicio() {
		return horainicio;
	}
	public void setHorainicio(String horainicio) {
		this.horainicio = horainicio;
	}
	public String getHorafim() {
		return horafim;
	}
	public void setHorafim(String horafim) {
		this.horafim = horafim;
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
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Ingresso getIngresso() {
		return ingresso;
	}
	public void setIngresso(Ingresso ingresso) {
		this.ingresso = ingresso;
	}
	public byte[] getFoto_evento() {
		return foto_evento;
	}
	public void setFoto_evento(byte[] foto_evento) {
		this.foto_evento = foto_evento;
	}

}
