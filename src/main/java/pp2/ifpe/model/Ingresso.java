package pp2.ifpe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

@Entity
public class Ingresso {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String tipoingresso;
	@DecimalMin(value = "0.00")
	private double valor;
	@Min(value = 0)
	private int quantidade;
	@Column(name = "comentarios")
	private String comentarios;
	
	@ManyToOne
	@JoinColumn(name="id_evento")
	private Evento evento;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	public String getTipoingresso() {
		return tipoingresso;
	}
	public void setTipoingresso(String tipoingresso) {
		this.tipoingresso = tipoingresso;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}

	
	

}
