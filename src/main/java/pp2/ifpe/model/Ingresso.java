package pp2.ifpe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

@Entity
public class Ingresso {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(length = 8)
	private String tipoingresso;
	@DecimalMin(value = "0.01")
	private double valor;
	@Min(value = 0)
	private int qtd;
	@Column(length = 50)
	private String desc;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	

}
