package com.example.test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.example.demo.RestraurentApplication;
import com.example.demo.controller.CustomerController;
import com.example.demo.dao.CustomerDao;
import com.example.demo.model.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
/*
 * The @SpringBootTest annotation loads the complete Spring application context.
 * Spring Boot provides the @SpringBootTest annotation which we can use to 
 * create an application context containing all the objects
 */
@SpringBootTest(classes =  RestraurentApplication.class)
/*
 * @WebMvcTest annotation is used for Spring MVC tests
 * The WebMvcTest annotation auto-configure MockMvc instance as well.
 */
@WebMvcTest(value=CustomerController.class)
public class TestCustomerController 
{
    @Autowired
	/*
	 * MockMVC class is part of Spring MVC test framework which helps in testing the controllers
	 *  explicitly starting a Servlet container.
	 *  MockMvc is defined as a main entry point for server-side Spring MVC testing
	 */
	 
	private MockMvc mockMvc;
    
    @MockBean
    /*
     * We can use the @MockBean to add mock objects to the Spring application context. 
     * The mock will replace any existing bean of the same type in the application context.
     *  If no bean of the same type is defined, a new one will be added.
     */
    private CustomerDao customerDao;
    
    

    @Before
    /*
     * We set up the MockMvc. We add the CustomerController to the standalone setup. 
     * The MockMvcBuilders.standaloneSetup() allows to register one or more controllers without the need to use the full WebApplicationContext.
     */
    public void setup()
    {
       this.mockMvc = MockMvcBuilders.standaloneSetup(new CustomerController()).setViewResolvers(viewResolver()).build();
    }
    private ViewResolver viewResolver()
	{
	    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

	    viewResolver.setPrefix("classpath:templates/");
	    viewResolver.setSuffix(".html");

	    return viewResolver;
	}

   @Test
   public void testCustomerPage() throws Exception 
   {
        this.mockMvc.perform(get("/").accept(MediaType.APPLICATION_JSON))//Specify what kind of an HTTP request is send to the system under test
                .andExpect(status().isOk())
                .andExpect(view().name("customer"))
                .andDo(MockMvcResultHandlers.print())
               .andReturn();
   }
   
   @Test
   public void testHomePage() throws Exception 
   {
        this.mockMvc.perform(get("/home").accept(MediaType.APPLICATION_JSON))//Specify what kind of an HTTP request is send to the system under test
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andDo(MockMvcResultHandlers.print())
               .andReturn();
   }
   
   
   
   
   
  
   
   
   
   
    
}
	


