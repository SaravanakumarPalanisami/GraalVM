package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.example.demo.entity.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class DemoApplicationTests {
	@Autowired
	private MockMvc mock;
	
	@Container
	private static MySQLContainer<?> mysqlContainer = new MySQLContainer<>("mysql:8.0.33")
    .withDatabaseName("mydatabase")
    .withUsername("username")
    .withPassword("password")
    .withExposedPorts(3306);
	


	@Test
	public void saveStudentTest() {
		List<Student> studentList = List.of(new Student(1, "ABC"), new Student(2, "DEF"));

		try {
		    // Convert the studentList to JSON
		    ObjectMapper objectMapper = new ObjectMapper();
		    String jsonBody = objectMapper.writeValueAsString(studentList);

		    // Send the POST request with the JSON data
		    mock.perform(post("/save")
		            .contentType(MediaType.APPLICATION_JSON)
		            .content(jsonBody))
		            .andExpect(status().isOk());
		} catch (Exception e) {
		    e.printStackTrace();
		}
		}
			      
	}


