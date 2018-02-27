package com.mybeardapi.test.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;

public class TestTokenResource extends AbstractIntegrationTest {

	@Test
	public void test01FindNoContent() throws Exception {
		mockMvc.perform(delete("/token/revoke")
    			.contentType(contentType).with(bearerToken))
    	.andExpect(status().isNoContent());
	}
	
}
