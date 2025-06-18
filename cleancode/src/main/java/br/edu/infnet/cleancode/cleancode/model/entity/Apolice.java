package br.edu.infnet.cleancode.cleancode.model.entity;

import java.time.LocalDateTime;

import br.edu.infnet.cleancode.cleancode.model.entity.enums.TipoSeguroEnum;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Apolice {

	
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String apoliceNumber;
	
	private TipoSeguroEnum tipoSeguro;
	
	private LocalDateTime dataInicialVigencia;
	
	private LocalDateTime dataFinalVigencia;
	
	private User user;

//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}

	public TipoSeguroEnum getTipoSeguro() {
		return tipoSeguro;
	}

	public void setTipoSeguro(TipoSeguroEnum tipoSeguro) {
		this.tipoSeguro = tipoSeguro;
	}

	public LocalDateTime getDataInicialVigencia() {
		return dataInicialVigencia;
	}

	public void setDataInicialVigencia(LocalDateTime dataInicialVigencia) {
		this.dataInicialVigencia = dataInicialVigencia;
	}

	public LocalDateTime getDataFinalVigencia() {
		return dataFinalVigencia;
	}

	public void setDataFinalVigencia(LocalDateTime dataFinalVigencia) {
		this.dataFinalVigencia = dataFinalVigencia;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Apolice [id=" + id + ", apoliceNumber=" + apoliceNumber + ", tipoSeguro=" + tipoSeguro
				+ ", dataInicialVigencia=" + dataInicialVigencia + ", dataFinalVigencia=" + dataFinalVigencia
				+ ", user=" + user + "]";
	}
	
	
	
	
}
