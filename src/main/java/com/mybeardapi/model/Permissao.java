package com.mybeardapi.model;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "permissao")
@SequenceGenerator(name = "SEQUENCE", sequenceName = "permissao_id_seq")
public class Permissao extends AbstractModel {

	private static final long serialVersionUID = -3678264920909477011L;

	@NotBlank
	private String descricao;

	public Permissao() {
	}
	public Permissao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
