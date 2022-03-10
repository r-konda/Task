package com.example.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.example.demo.controller.LunchMenuController;
import com.example.demo.controller.MorningMenuController;
import com.example.demo.model.LunchMenu;
import com.example.demo.model.MorningMenu;
import com.example.demo.service.LunchMenuService;
import com.example.demo.service.MorningMenuService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(value = LunchMenuController.class)
public class TestLunchMenuController 
{
	private MockMvc mockMvc;
	
	
	
	@Mock
	private LunchMenuService lunchMenuService;
	
	@InjectMocks
	private LunchMenuController LunchMenuController;
	
	LunchMenu menu1=new LunchMenu(1, "White Rice", 450);
	LunchMenu menu2=new LunchMenu(2, "Curd Rice", 350);
	LunchMenu menu3=new LunchMenu(3, "Samber Rice", 300);
	LunchMenu menu4=new LunchMenu(4, "Pogal Rice", 400);
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
		this.mockMvc=MockMvcBuilders.standaloneSetup(LunchMenuController).setViewResolvers(viewResolver()).build();
	}
	private ViewResolver viewResolver()
	{
	    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

	    viewResolver.setPrefix("classpath:templates/");
	    viewResolver.setSuffix(".html");

	    return viewResolver;
	}
	@Test
	public void testViewLunchMenuHomePage() throws Exception
	{
		List<LunchMenu> list=new ArrayList<>(Arrays.asList(menu1,menu2,menu3,menu4));
		when(lunchMenuService.getAllLunchMenuList()).thenReturn(list);

		String URI = "/lunch";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		 mockMvc.perform(requestBuilder).andExpect(MockMvcResultMatchers.view().name("lunch")).andExpect(MockMvcResultMatchers.model().attribute("lunchList", list)).andDo(print()).andReturn();
		 

//		String expectedJson = this.mapToJson(list);
//		String outputInJson = result.getResponse().getContentAsString();
//		//assertEquals(expectedJson., outputInJson.equals(list));
	}
	
//	/**
//	 * Maps an Object into a JSON String. Uses a Jackson ObjectMapper.
//	 */
//	private String mapToJson(Object object) throws JsonProcessingException {
//		ObjectMapper objectMapper = new ObjectMapper();
//		return objectMapper.writeValueAsString(object);
//	}
//	
	

}