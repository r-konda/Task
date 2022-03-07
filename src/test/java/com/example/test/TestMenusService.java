package com.example.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.RestraurentApplication;
import com.example.demo.model.Customer;
import com.example.demo.model.DinnerMenu;
import com.example.demo.model.LunchMenu;
import com.example.demo.model.MorningMenu;
import com.example.demo.model.MorningMenuDetails;
import com.example.demo.service.DinnerMenuService;
import com.example.demo.service.LunchMenuService;
import com.example.demo.service.MorningMenuService;

@SpringBootTest(classes = RestraurentApplication.class)
@RunWith(SpringRunner.class)

public class TestMenusService 
{
	@Autowired
	private MorningMenuService morningMenuService;
	
	@Autowired
	private LunchMenuService lunchMenuService;
	
	@Autowired
	private DinnerMenuService dinnerMenuService;
	
	@Test
	public void testGetDiscountApplicableCustomersForMorningMenu()
	{
		List<Customer> list=morningMenuService.getDiscountApplicableCustomers();
		//isGreaterThan() Verifies that the actual value is greater than the given one. 
		
		//assertTha()  the parameter is actual value.
		   assertThat(list).size().isGreaterThan(0);
		   
    }
	
	@Test
	public void testGetAllMorningMenuList()
	{
		List<MorningMenu> morningMenusList=Arrays.asList(
                new MorningMenu(1,"Idli",25),
                new MorningMenu(2,"Poori",35),
                new MorningMenu(3,"Upma",40),
                new MorningMenu(4,"Dosa",45));
                
       
		List<MorningMenu> list=morningMenuService.getAllMorningMenuList();
		    assertEquals(morningMenusList.size(), list.size());
		   
	}
	
	@Test
	public void testGetDiscountApplicableCustomersForLunchMenu()
	{
		List<Customer> list=lunchMenuService.getDiscountApplicableCustomers();
		//isGreaterThan() Verifies that the actual value is greater than the given one. 
		
		//assertTha()  the parameter is actual value.
		   assertThat(list).size().isGreaterThan(0);
		   
    }
	
	@Test
	public void testGetAllLunchMenuList()
	{
		List<LunchMenu> lLunchMenus=Arrays.asList(
                new LunchMenu(1,"White Rice",450),
                new LunchMenu(2,"Curd Rice",350),
                new LunchMenu(3,"Samber Rice",300),
                new LunchMenu(4,"Pogal Rice",400));
		
		List<LunchMenu> list=lunchMenuService.getAllLunchMenuList();
		 assertEquals(lLunchMenus.size(), list.size());
		   
	}
	
	
	
	@Test
	public void testGetDiscountApplicableCustomersForDinnerMenu()
	{
		
		List<Customer> list=dinnerMenuService.getDiscountApplicableCustomers();
		//isGreaterThan() Verifies that the actual value is greater than the given one. 
		
		//assertTha()  the parameter is actual value.
		   assertThat(list).size().isGreaterThan(0);
		   
    }
	
	@Test
	public void testGetAllDinnerMenuList()
	{
		List<DinnerMenu> lDinnerMenus=Arrays.asList(
                new DinnerMenu(1,"Egg Biryani",350),
                new DinnerMenu(2,"Mutton Biryani",600),
                new DinnerMenu(3,"Chicken Biryani",450),
                new DinnerMenu(4,"Mandi",650));
		
		List<DinnerMenu> list=dinnerMenuService.getAllDinnerMenuList();
		 assertEquals(lDinnerMenus.size(), list.size());

		   
	}

	
	
	
	

}
