package com.example.taskTwoThree.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;

//	@MockBean
//	private HeadService headService;

	@Test
	public void testSayHello() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v2_3/employee/sayhello"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().string("Say Hello..."));
	}
}
////	@Test
//	void test() throws Exception {
////		assertThat(employeeController).isNotNull();
//		RequestBuilder request = get("/api/v2_3/employee/process/EXCELREAD/CSVWRITE");
//		MvcResult res = mockMvc.perform(request).andReturn();
//		assertEquals(res.getResponse().getStatus(), 200);
//	}
//
//		@Autowired
//		private TestRestTemplate restTemplate;
//		@Test
//		public void testYourController() {
//			ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:" + 8081 + "/api/v2_3/employee/process/EXCELREAD/CSVWRITE",
//					String.class);
//			// Add assertions to check the response
//			assert response.getStatusCode() == HttpStatus.OK;
//			// Add more assertions as needed
//		}
//	}
