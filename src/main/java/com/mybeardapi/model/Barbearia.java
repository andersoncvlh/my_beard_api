package com.mybeardapi.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "empresa")
@SequenceGenerator(name = "SEQUENCE", sequenceName = "empresa_id_seq")
public class Barbearia extends AbstractModel {

	private static final long serialVersionUID = 1204189814591357576L;

	@Column(name = "nome_fantasia")
	private String nomeFantasia;
	
	@Column(name = "razao_social")
	private String razaoSocial;
	
	private String cnpj;
	
	private String email;
	
	@Embedded
	private Endereco endereco;

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
}
