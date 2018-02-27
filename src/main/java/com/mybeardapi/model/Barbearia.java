package com.mybeardapi.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "empresa")
@SequenceGenerator(name = "SEQUENCE", sequenceName = "empresa_id_seq")
public class Barbearia extends AbstractModel {

	private static final long serialVersionUID = 1204189814591357576L;

	@NotBlank
	@Column(name = "nome_fantasia")
	private String nomeFantasia;
	
	@NotBlank
	@Column(name = "razao_social")
	private String razaoSocial;
	
	@NotBlank
	@Size(min=14, max=20)
	private String cnpj;
	
	@NotBlank
	@Size(min=5, max=200)
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
