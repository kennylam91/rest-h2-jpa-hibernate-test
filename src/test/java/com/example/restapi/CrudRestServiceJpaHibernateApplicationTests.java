package com.example.restapi;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.restapi.controller.StudentController;
import com.example.restapi.model.Student;
import com.example.restapi.service.StudentService;
import com.sun.glass.ui.Application;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@WebMvcTest(StudentController.class)
@AutoConfigureMockMvc
public class CrudRestServiceJpaHibernateApplicationTests {
	/*
	 * @Autowired private TestRestTemplate restTemplate;
	 */

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StudentService studentService;

//	@LocalServerPort
//	private int port;

//	private String getRootUrl() {
//		return "http://localhost:" + port;
//	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void testGetAllStudents() throws Exception {

		this.mockMvc.perform(get("/students")).andDo(print()).andExpect(status().isOk());

//		HttpHeaders headers = new HttpHeaders();
//		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//		ResponseEntity<String> response = restTemplate.exchange(getRootUrl()+"/students",
//				HttpMethod.GET, entity, String.class);
//		assertNotNull(response.getBody());
	}
//	
//	@Test
//	public void testGetStudentById() {
//		Student student = restTemplate.getForObject(getRootUrl() + "/students/10001", Student.class);
//		assertNotNull(student);
//	}

}
