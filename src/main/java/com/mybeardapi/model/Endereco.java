package com.mybeardapi.model;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

	private String logradouro;
	private Long numero;
	private String bairro;
	private String cep;
	private String cidade;
	private String estado;
	private String complemento;
	
	public Endereco() {
	}
	public Endereco(String cep) {
		this.cep = cep;
	}
	public Endereco(
			String logradouro, 
			Long numero, 
			String bairro, 
			String cidade,
			String estado,
			String complemento,
			String cep
		) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.complemento = complemento;
		this.cep = cep;
	}
	
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
}
