package com.javatester.book.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.javatester.book.test.AbstractTest;

/* DO NOT MODIFY THIS CLASS! */
@AutoConfigureMockMvc
@WebMvcTest(BookControllerImpl.class)
@ContextConfiguration(classes={Application.class})
public class BookControllerTest extends AbstractTest {
	
	@Autowired
	private MockMvc mock;
	
	@Test @Order(1) void testNoArgConstructor() {
		newBookController();
	}

	@Test @Order(2) void getAllTest() throws Exception {
		mock.perform(get("/books"))
		    .andExpect(jsonPath("$.length()", greaterThan(80)))
		    .andExpect(status().isOk());
	}
	
	@Test @Order(3) void getValidIsbnTest() throws Exception {
		mock.perform(get("/books/9998575321081"))
		    .andExpect(jsonPath("$.title", is("World Languages")))
		    .andExpect(jsonPath("$.isbn", is(9998575321081L)))
		    .andExpect(status().isOk());
	}
	
	@Test @Order(4) void getInvalidIsbnTest() throws Exception {
		mock.perform(get("/books/9198575321081"))
		    .andExpect(status().isNotFound());
	}
	
	@Test @Order(5) void validDeleteTest() throws Exception {
		mock.perform(get("/books/9998575321081"))
		    .andExpect(status().isOk());
	}
	
	@Test @Order(6) void invalidDeleteTest() throws Exception {
		mock.perform(get("/books/9198575321081"))
		    .andExpect(status().isNotFound());
	}
}