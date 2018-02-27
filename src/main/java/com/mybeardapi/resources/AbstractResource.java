package com.mybeardapi.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

public abstract class AbstractResource {

	@Autowired
	private ApplicationEventPublisher publisher;
	
	public ApplicationEventPublisher getPublisher() {
		return publisher;
	}

}
