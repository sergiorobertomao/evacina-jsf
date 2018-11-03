package br.ifam.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Vacinacao implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO )
	private long id;
	private String data;
	private String dose;
	@OneToOne
	private Vacina vacina;
	
	public Vacinacao() {
		// TODO Auto-generated constructor stub
	}
	
	public Vacinacao(String data, String dose, Vacina vacina) {
		this.data = data;
		this.dose =dose;
		this.vacina = vacina;
	}
	public Vacina getVacina() {
		return vacina;
	}
	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getDose() {
		return dose;
	}
	public void setDose(String dose) {
		this.dose = dose;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
