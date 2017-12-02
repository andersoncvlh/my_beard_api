package com.mybeardapi.test.integration;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.mybeardapi.MybeardApiApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(
		  webEnvironment = WebEnvironment.RANDOM_PORT,
		  classes = MybeardApiApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(
		  locations = "classpath:application-integrationtest.properties")
public class AbstractIntegrationTest {

	@Autowired
    protected MockMvc mockMvc;
	
	@SuppressWarnings("rawtypes")
	protected HttpMessageConverter mappingJackson2HttpMessageConverter;

	protected MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(),
			Charset.forName("utf8"));
	
	@Autowired
    protected void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
            .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
            .findAny()
            .orElse(null);
    }
	
	@SuppressWarnings("unchecked")
	protected String json(Object o) throws IOException {
		MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
		this.mappingJackson2HttpMessageConverter.write(o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
		return mockHttpOutputMessage.getBodyAsString();
	}

}
