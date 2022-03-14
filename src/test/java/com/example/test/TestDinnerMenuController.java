package com.example.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.demo.controller.DinnerMenuControler;
import com.example.demo.model.DinnerMenu;
import com.example.demo.service.DinnerMenuService;



@WebMvcTest(value = DinnerMenuControler.class)
public class TestDinnerMenuController 
{
    
	private MockMvc mockMvc;
	
	
	
	@Mock
	private DinnerMenuService dinnerService;
	
	@InjectMocks
	private DinnerMenuControler dinnerMenuController;
	
	DinnerMenu menu1=new DinnerMenu(1,"Egg Biryani",350);
	DinnerMenu menu2=new DinnerMenu(2,"Mutton Biryani",600);
	DinnerMenu menu3=new DinnerMenu(3,"Chicken Biryani",450);
	DinnerMenu menu4=new DinnerMenu(4,"Mandi",650);
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
		this.mockMvc=MockMvcBuilders.standaloneSetup(dinnerMenuController).setViewResolvers(viewResolver()).build();
	}
	private ViewResolver viewResolver()
	{
	    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

	    viewResolver.setPrefix("classpath:templates/");
	    viewResolver.setSuffix(".html");

	    return viewResolver;
	}
	@Test
	public void testViewHomePage() throws Exception
	{
		List<DinnerMenu> list=new ArrayList<>(Arrays.asList(menu1,menu2,menu3,menu4));
		when(dinnerService.getAllDinnerMenuList()).thenReturn(list);

		String URI = "/dinner";
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				URI).accept(
				MediaType.APPLICATION_JSON);

		 mockMvc.perform(requestBuilder).
		 andExpect(MockMvcResultMatchers.view().name("dinner"))
		 .andExpect(MockMvcResultMatchers.model().attribute("dinnerList", list))
		 .andDo(print()).andReturn();

		 


	}


}