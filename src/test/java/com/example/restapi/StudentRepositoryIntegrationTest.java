package com.example.restapi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.restapi.model.Student;
import com.example.restapi.repository.StudentRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentRepositoryIntegrationTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private StudentRepository studentRepository;

	@Test
	public void whenSaveStudent_thenReturnStudent() {

		// given
		Student student1 = new Student("Lam", "101080382");

		// when
		studentRepository.save(student1);

		// then
		List<Student> studentFound = studentRepository.findByName(student1.getName());
		assertThat(studentFound.get(0)).isEqualTo(student1);
	}

	@Test
	public void whenFindAll_thenReturnStudents() {

		// given
		Student student1 = new Student("Lam", "101080382");
		entityManager.persist(student1);
		Student student2 = new Student("Thom", "0355907049");
		entityManager.persist(student2);
		entityManager.flush();
		List<Student> students = new ArrayList<Student>();
		students.add(student1);
		students.add(student2);

		// when
		List<Student> studentsFound = studentRepository.findAll();

		// then
		assertThat(students.get(0)).isEqualTo(studentsFound.get(0));
		assertThat(students.get(1)).isEqualTo(studentsFound.get(1));
	}

	@Test
	public void whenFindById_thenReturnStudent() {
		// given
		Student student = new Student("Lam", "101080382");
		entityManager.persist(student);
		entityManager.flush();

		// when
		Student studentFound = studentRepository.findById(student.getId()).get();

		// then
		assertThat(student).isEqualTo(studentFound);
	}

	@Test
	public void whenDeleteStudent_thenReturnNull() {
		// given
		Student student = new Student("Lam", "101080382");
		entityManager.persist(student);
		entityManager.flush();

		// when
		studentRepository.deleteById(student.getId());
		List<Student> studentsFound = studentRepository.findAll();

		// then
		assertThat(studentsFound).isEmpty();
	}
	
	@Test
	public void whenFindByName_thenReturnStudents() {
		
		//given
		Student student = new Student("Test","13265400");
		entityManager.persist(student);
		entityManager.flush();
		
		//when
		List<Student> studentsFound = studentRepository.findByName(student.getName());
		
		//then
		assertThat(studentsFound.get(0)).isEqualTo(student);
	}

}
