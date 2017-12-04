package com.mybeardapi.event;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationEvent;

public class RecursoCriadoEvent extends ApplicationEvent {

	private static final long serialVersionUID = -3838375729020089572L;
	
	private HttpServletResponse response;
	private Long codigo;
	
	public RecursoCriadoEvent(Object source, HttpServletResponse response, Long id) {
		super(source);
		this.response = response;
		this.codigo = id;
	}

	public HttpServletResponse getResposne() {
		return response;
	}

	public Long getCodigo() {
		return codigo;
	}

}
