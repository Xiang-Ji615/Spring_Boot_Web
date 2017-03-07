package test.java.spring.boot.mvc.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations = "classpath:Spring.xml")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class MVCTest {

	@Autowired
	private MockMvc mockMvc;


	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void shouldReturnDefaultMessage() throws Exception {
		this.mockMvc.perform(get("/Rest/Test")).andExpect(status().isOk())
				.andExpect(content().string(containsString("Test")));
//				andDo(print());
	}

	@Test
	public void shouldReturnTest() throws Exception {
		assertThat(this.restTemplate.getForObject(
				"https://www.google.com.au/webhp?hl=en&sa=X&ved=0ahUKEwiP44LQuJPSAhVFXbwKHS4hAh0QPAgD#hl=en&q=test",
				String.class)).contains("test");
	}
}
