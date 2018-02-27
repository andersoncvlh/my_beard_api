package com.mybeardapi.test.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.mybeardapi.model.Usuario;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestUsuarioResource extends AbstractIntegrationTest {

	@Test
    public void test01FindNoContent() throws Exception {
    	mockMvc.perform(get("/usuarios")
    			.contentType(contentType).with(bearerToken))
    	.andExpect(status().isNoContent());
    }
	@Test
	public void test01FindById() throws Exception {
		mockMvc.perform(get("/usuarios/1")
				.contentType(contentType).with(bearerToken))
		.andExpect(status().isNoContent());
	}
	@Test
	public void test02NovoUsuarioValidateSenha() throws Exception {
		Usuario u = new Usuario();
		u.setEmail("mock@mock");
		u.setNome("mock");
		u.setSenha("mock");
		
		String content = json(u);
		Exception exception = mockMvc.perform(post("/usuarios")
    			.contentType(contentType).with(bearerToken)
    			.content(content))
    	.andExpect(status().isBadRequest())
    	.andReturn().getResolvedException();
		
		Assert.assertTrue(exception instanceof MethodArgumentNotValidException);
	}
	@Test
	public void test02NovoUsuario() throws Exception {
		Usuario u = new Usuario();
		u.setEmail("mock@mock");
		u.setNome("mockmock");
		u.setSenha("mockmock");
		
		String content = json(u);
		mockMvc.perform(post("/usuarios")
				.contentType(contentType).with(bearerToken)
				.content(content))
				.andExpect(status().isCreated());
	}
	@Test
	public void test04FindByFilter() throws Exception {
		mockMvc.perform(get("/usuarios")
    			.contentType(contentType).with(bearerToken))
    	.andExpect(status().isOk());
	}
	@Test
	public void test05FindById() throws Exception {
		mockMvc.perform(get("/usuarios/1")
				.contentType(contentType).with(bearerToken))
		.andExpect(status().isOk());
	}
	@Test
	public void test06Delete() throws Exception {
		mockMvc.perform(delete("/usuarios/1")
				.contentType(contentType).with(bearerToken))
		.andExpect(status().isNoContent());
	}
	
}
