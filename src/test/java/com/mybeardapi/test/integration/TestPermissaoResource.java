package com.mybeardapi.test.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.mybeardapi.model.Permissao;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPermissaoResource extends AbstractIntegrationTest {

	@Test
	public void test01FindNoContent() throws Exception {
		mockMvc.perform(get("/permissoes")
    			.contentType(contentType).with(bearerToken))
    	.andExpect(status().isNoContent());
	}
	@Test
	public void test01FindByDescricaoNoContent() throws Exception {
		mockMvc.perform(get("/permissoes/TEST_PERMISSAO")
    			.contentType(contentType).with(bearerToken))
    	.andExpect(status().isNoContent());
	}
	@Test
	public void test02NovaPermissao() throws Exception {
		Permissao permissao = new Permissao();
		permissao.setDescricao("TEST_PERMISSAO");
		String content = this.json(permissao);
		
		mockMvc.perform(post("/permissoes")
				.contentType(contentType).with(bearerToken)
				.content(content))
		.andExpect(status().isCreated());
	}
	@Test
	public void test03FindByDescricao() throws Exception {
		mockMvc.perform(get("/permissoes/TEST_PERMISSAO")
    			.contentType(contentType).with(bearerToken))
    	.andExpect(status().isOk());
	}
	@Test
	public void test04FindAll() throws Exception {
		mockMvc.perform(get("/permissoes")
    			.contentType(contentType).with(bearerToken))
    	.andExpect(status().isOk());
	}
	
}
