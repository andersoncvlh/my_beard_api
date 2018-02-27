package com.mybeardapi.test.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.mybeardapi.model.Barbearia;
import com.mybeardapi.model.Endereco;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestBarbeariaResource extends AbstractIntegrationTest{

    @Test
    public void test01FindNoContent() throws Exception {
    	mockMvc.perform(get("/barbearias")
    			.contentType(contentType).with(bearerToken))
    	.andExpect(status().isNoContent());
    }
    @Test
    public void test02NovaBarbearia() throws Exception {
    	Barbearia b = new Barbearia();
    	b.setCnpj("99.999.999/9999-99");
    	b.setEmail("contato@barbearia.com.br");
    	b.setEndereco(new Endereco("61.616-22"));
    	b.setNomeFantasia("Fantasia");
    	b.setRazaoSocial("Razao Social");
    	String content = this.json(b);
    	
    	mockMvc.perform(
    			post("/barbearias")
    			.contentType(contentType).with(bearerToken)
    			.content(content))
    	.andExpect(status().isCreated());
    }
    @Test
    public void test03FindAll() throws Exception {
    	mockMvc.perform(get("/barbearias")
    			.contentType(contentType).with(bearerToken))
    	.andExpect(status().isOk());
    }
    @Test
    public void test04FindById() throws Exception {
    	mockMvc.perform(get("/barbearias/1")
    			.contentType(contentType).with(bearerToken))
    	.andExpect(status().isOk());
    }
    @Test
    public void test05FindByIdNoContent() throws Exception {
    	mockMvc.perform(get("/barbearias/111")
    			.contentType(contentType).with(bearerToken))
    	.andExpect(status().isNoContent());
    }
    @Test
    public void test06Delete() throws Exception {
    	mockMvc.perform(MockMvcRequestBuilders.delete("/barbearias/1")
    			.contentType(contentType).with(bearerToken))
    	.andExpect(status().isNoContent());
    }
   
}
