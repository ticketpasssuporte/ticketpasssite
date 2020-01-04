package pp2.ifpe.model;
import java.util.Calendar;
import java.util.Date;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Evento {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 50)
	private String nome;
	private Boolean status;
	@DateTimeFormat(pattern = "MM/dd/yyyy") @FutureOrPresent
	private Date dataInicio;
	@Temporal(value =TemporalType.TIME) @Future
	private Date horaInicio = Calendar.getInstance().getTime();;
	@Temporal(value =TemporalType.TIME) @Future
	private Date horaFim = Calendar.getInstance().getTime();
	@Column(length = 150)
	private String desc_evento;
	@Column(length = 150)
	private String desc_org;
	
	@ManyToOne
	@JoinColumn(name="id_categoria")
	private Categoria categoria;
	
	@ManyToOne
	@JoinColumn(name="id_usuario")
	private Usuario usuario;
	
	
		
	@Lob @Column(name = "foto_evento", columnDefinition="TEXT")
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
	
	
	public Boolean getStatus() {
		return status;
	}



	public void setStatus(Boolean status) {
		this.status = status;
	}



	public Date getDataInicio() {
		return dataInicio;
	}



	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}



	public Date getHoraInicio() {
		return horaInicio;
	}



	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}



	public Date getHoraFim() {
		return horaFim;
	}



	public void setHoraFim(Date horaFim) {
		this.horaFim = horaFim;
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



	public byte[] getFoto_evento() {
		return foto_evento;
	}



	public void setFoto_evento(byte[] foto_evento) {
		this.foto_evento = foto_evento;
	}
	
	
	
}
