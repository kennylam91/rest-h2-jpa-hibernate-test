package com.example.restapi;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.restapi.model.Student;
import com.example.restapi.repository.StudentRepository;
import com.example.restapi.service.StudentService;
import com.example.restapi.service.impl.StudentServiceImpl;

@RunWith(SpringRunner.class)
public class StudentServiceImplIntegrationTest {

	@TestConfiguration
	static class StudentServiceImplTestContextConfiguration {
		
		@Bean
		public StudentService studentService(){
			return new StudentServiceImpl();
		}
		
	}
	
	@Autowired
	private StudentService studentService;
	
	@MockBean
	private StudentRepository studentRepository;
	
	@Before
	public void setup() {
		Student student = new Student("Lam", "092813");
		student.setId(1L);
		Mockito.when(studentRepository.findById(1L))
		.thenReturn(Optional.of(student));
	}
	
	@Test
	public void whenValidId_thenStudentShoudBeFound() {
		Long id = 1L;
		Optional<Student> studentFound = studentRepository.findById(id);
		assertThat(studentFound.get().getId()).isEqualTo(id);
	}
	
	
}
