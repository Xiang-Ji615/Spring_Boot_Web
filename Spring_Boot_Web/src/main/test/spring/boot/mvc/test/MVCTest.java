package main.test.spring.boot.mvc.test;

import static org.assertj.core.api.Assertions.assertThat;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import main.java.spring.boot.daos.IPersonDao;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:Spring.xml")
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@AutoConfigureMockMvc
public class MVCTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	@Qualifier("PersonDaoDEV")
	private IPersonDao personDao;

	public void setPersonDao(IPersonDao personDao) {
		this.personDao = personDao;
	}

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/Rest/Test")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("Test")));
	}

	@Test
	public void shouldReturnTest() throws Exception {
		assertThat(this.restTemplate.getForObject(
				"https://www.google.com.au/webhp?hl=en&sa=X&ved=0ahUKEwiP44LQuJPSAhVFXbwKHS4hAh0QPAgD#hl=en&q=test",
				String.class)).contains("test");
	}
}
