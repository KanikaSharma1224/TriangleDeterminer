package com.triangledeterminer.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.triangledeterminer.model.ShapeDeterminer;
import com.triangledeterminer.model.Triangle;
import com.triangledeterminer.model.TriangleDeterminer;
import com.triangledeterminer.model.Type;
import com.triangledeterminer.validation.Validator;

@WebMvcTest(controllers = TriangleController.class)
class TriangleControllerTest {
	private static final ObjectMapper mapper = new ObjectMapper();
	private Triangle triangle;

	@Autowired
	private MockMvc mockMVC;

	@MockBean
	private ShapeDeterminer triangleDeterminer;

	@MockBean
	private Validator validator;

	@BeforeEach
	public void setUp() {
		triangle = new Triangle();
	}

	@Test
	void testGivesOkWhenControllersListensToHTTPRequest() throws Exception {
		triangle.setSide1(3.1f);
		triangle.setSide2(3.2f);
		triangle.setSide3(3.3f);
		String input = mapper.writeValueAsString(triangle);
		Mockito.doNothing().when(validator).validateTriangle(triangle);
		mockMVC.perform(MockMvcRequestBuilders.post("/triangle/type")
				.contentType(MediaType.APPLICATION_JSON).content(input).accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
	}

}
