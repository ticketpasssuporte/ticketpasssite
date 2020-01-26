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
	private String valor;
	
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

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
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


}
