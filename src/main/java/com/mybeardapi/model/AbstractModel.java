package com.mybeardapi.model;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractModel implements Serializable {

	private static final long serialVersionUID = -578444145720254091L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQUENCE")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
