package com.example.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.example.demo.controller.MorningMenuController;
import com.example.demo.model.MorningMenu;
import com.example.demo.service.MorningMenuService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
@WebMvcTest(value = MorningMenuController.class)
public class TestMorningMenuController 
{
	
	private MockMvc mockMvc;
	
	
	
	@Mock
	private MorningMenuService morningMenuService;
	
	@InjectMocks
	private MorningMenuController morningMenuController;
	
	MorningMenu menu1=new MorningMenu(1, "Idli", 25);
	MorningMenu menu2=new MorningMenu(2, "Poori", 35);
	MorningMenu menu3=new MorningMenu(3, "Upma", 40);
	MorningMenu menu4=new MorningMenu(4, "Dosa", 45);
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
		this.mockMvc=MockMvcBuilders.standaloneSetup(morningMenuController).setViewResolvers(viewResolver()).build();
	}
	private ViewResolver viewResolver()
	{
	    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

	    viewResolver.setPrefix("classpath:templates/");
	    viewResolver.setSuffix(".html");

	    return viewResolver;
	}
	
	@Test
	public void testViewMorningMenuHomePage() throws Exception
	{
		List<MorningMenu> list=new ArrayList<>(Arrays.asList(menu1,menu2,menu3,menu4));
		when(morningMenuService.getAllMorningMenuList()).thenReturn(list);
		
		String URI = "/morning";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		 mockMvc.perform(requestBuilder)
		 .andExpect(MockMvcResultMatchers.view().name("morning"))
		 .andExpect(MockMvcResultMatchers.model().attribute("morningList", list))
		 .andDo(print()).andReturn();

//		String expectedJson = this.mapToJson(list);
//		String outputInJson = result.getResponse().getContentAsString();
//		assertEquals(expectedJson.equals(list), outputInJson.equals(list));
	}
	
//	/**
//	 * Maps an Object into a JSON String. Uses a Jackson ObjectMapper.
//	 */
//	private String mapToJson(Object object) throws JsonProcessingException {
//		ObjectMapper objectMapper = new ObjectMapper();
//		return objectMapper.writeValueAsString(object);
//	}
	
	
	
	

}
