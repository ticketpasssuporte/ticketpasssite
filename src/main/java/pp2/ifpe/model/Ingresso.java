package pp2.ifpe.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Ingresso {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(nullable = false)
	private Boolean statusLote = false;
	
    @NotNull
	private int lote;
	
    @NotNull
	private String nomeIngresso;
	
    @NotNull
	private double valor;
	
	private String tipoIngresso;
	

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id_evento", referencedColumnName="id",nullable=false)
	private Evento evento;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getStatusLote() {
		return statusLote;
	}

	public void setStatusLote(Boolean statusLote) {
		this.statusLote = statusLote;
	}


	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getLote() {
		return lote;
	}

	public void setLote(int lote) {
		this.lote = lote;
	}

	public String getNomeIngresso() {
		return nomeIngresso;
	}

	public void setNomeIngresso(String nomeIngresso) {
		this.nomeIngresso = nomeIngresso;
	}

	public String getTipoIngresso() {
		return tipoIngresso;
	}

	public void setTipoIngresso(String tipoIngresso) {
		this.tipoIngresso = tipoIngresso;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public Ingresso(Integer id, @NotNull Boolean statusLote, @NotNull int lote, @NotNull String nomeIngresso,
			@NotNull double valor, String tipoIngresso, Evento evento) {
		super();
		this.id = id;
		this.statusLote = statusLote;
		this.lote = lote;
		this.nomeIngresso = nomeIngresso;
		this.valor = valor;
		this.tipoIngresso = tipoIngresso;
		this.evento = evento;
	}

	public Ingresso() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Ingresso [id=" + id + ", statusLote=" + statusLote + ", lote=" + lote + ", nomeIngresso=" + nomeIngresso
				+ ", valor=" + valor + ", tipoIngresso=" + tipoIngresso + ", evento=" + evento + "]";
	}


}
