package com.culqi.test;
import static org.junit.Assert.assertEquals;
import com.culqi.model.Token;
import com.culqi.model.Card;
import com.culqi.service.CulqiService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)
@WebMvcTest(value = CulqiController.class, secure = false)
public class TestApplicationTests {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private CulqiService culqiService;
	String exampleTarjeta ="{\"pan\": \"4444333322221111\", \"exp_year\": 2020, \"exp_month\": 10}";
	@Test
	public void testCulqiRest() throws Exception {
		Card requestObject =new Card("4444333322221111",2020,10);
		Token mockObjeto = new Token(requestObject);
        mockObjeto.setToken("tkn_live_4444333322221111-2020-10");
        mockObjeto.setBrand("visa");
        mockObjeto.setCreation_dt("2018-08-07 10:47:35");
		//culqiService.getResultAPI to respond back with mockTarjeta
		Mockito.when(
				culqiService.generateResponseObject( Mockito.any(Card.class))).thenReturn(mockObjeto);

		//Send Token as body to /tokens
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(
				"/tokens")
				.accept(MediaType.APPLICATION_JSON).content(exampleTarjeta)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();
		System.out.println(response);
		assertEquals(HttpStatus.OK.value(), response.getStatus());



	}

}
