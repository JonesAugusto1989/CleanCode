package br.edu.infnet.cleancode.cleancode.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String cep;
	
	private String logradouro;
	
	private String complemento;
	
	private String unidade;
	
	private String bairro;
	
	private String localidade;
	
	private String uf;
	
	private String estado;
	
	private String regiao;
	
	@ManyToOne
	@JsonBackReference
	private User user;
	
	

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	
	public Address(Builder builder) {
		
		this.cep = builder.cep;
		this.logradouro = builder.logradouro;
		this.complemento = builder.complemento;
		this.unidade = builder.unidade;
		this.bairro = builder.bairro;
		this.localidade = builder.localidade;
		this.uf = builder.uf;
		this.estado = builder.estado;
		this.regiao = builder.regiao;
	}
	
	public Address() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", logradouro=" + logradouro + ", complemento=" + complemento + ", unidade="
				+ unidade + ", bairro=" + bairro + ", localidade=" + localidade + ", uf=" + uf + ", estado=" + estado
				+ ", regiao=" + regiao + "]";
	}
	
	public static class Builder{
				
		private String cep;		
		private String logradouro;
		private String complemento;	
		private String unidade;		
		private String bairro;		
		private String localidade;		
		private String uf;		
		private String estado;	
		private String regiao;
				

	public Builder cep(String cep) {
		this.cep = cep;
		return this;
	}

	public Builder logradouro(String logradouro) {
		this.logradouro = logradouro;
		return this;
	}
	
	public Builder complemento(String complemento) {
		this.complemento = complemento;
		return this;
	}
	
	
	public Builder unidade(String unidade) {
		this.unidade = unidade;
		return this;
	}
	
	public Builder bairro(String bairro) {
		this.bairro = bairro;
		return this;
	}
	
	public Builder localidade(String localidade) {
		this.localidade = localidade;
		return this;
	}
	
	public Builder uf( String uf) {
		this.uf = uf;
		return this;
	}
	
	public Builder estado(String estado) {
		this.estado = estado;
		return this;
	}
	
	public Builder regiao(String regiao) {
		this.regiao = regiao;
		return this;
	}
	public Address build() {
        return new Address(this);
    }
	}
}
