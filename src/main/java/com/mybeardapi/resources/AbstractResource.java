package com.mybeardapi.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.mybeardapi.model.AbstractModel;

public abstract class AbstractResource {

	@Autowired
	private ApplicationEventPublisher publisher;
	
	public URI getURI(AbstractModel abstractModel) {
		return ServletUriComponentsBuilder.fromCurrentRequestUri()
				.path("/{codigo}").buildAndExpand(abstractModel.getId()).toUri();
	}

	public ApplicationEventPublisher getPublisher() {
		return publisher;
	}

}
