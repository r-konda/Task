package com.example.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.RestraurentApplication;
import com.example.demo.dao.DinnerMenuDao;
import com.example.demo.dao.LunchMenuDao;
import com.example.demo.dao.MorningMenuDao;
import com.example.demo.model.DinnerMenu;
import com.example.demo.model.LunchMenu;
import com.example.demo.model.MorningMenu;

@SpringBootTest(classes = RestraurentApplication.class)
@RunWith(SpringRunner.class)
public class TestMenuDao
{
	
	@Autowired
	private MorningMenuDao morningMenuDao;
	
	@Autowired
	private LunchMenuDao lunchMenuDao;
	
	@Autowired
	private DinnerMenuDao dinnerMenuDao;
	
	@Test
	public void testGetAllMoriningMenu()
	{
		List<MorningMenu> lMorningMenus=Arrays.asList(
                new MorningMenu(1,"Idli",25),
                new MorningMenu(2,"Poori",35),
                new MorningMenu(3,"Upma",40),
                new MorningMenu(4,"Dosa",45));
                
        List<MorningMenu> all=morningMenuDao.getAllMorningMenu();
	
//		 Assert.assertEquals(4, lMorningMenus.size());
	    Assert.assertEquals(lMorningMenus.size(), all.size());
		 
	}
	
	@Test
	public void testGetMorning()
	{
		MorningMenu morningMenu=new MorningMenu();
		morningMenu.setId(1);
		morningMenu.setName("Idli");
		morningMenu.setPrice(25);
		MorningMenu morningMenus=morningMenuDao.getMorning(morningMenu.getId());
		assertEquals(morningMenu.getId(), morningMenus.getId());
	}
	
	
	@Test
	public void testGetAllLunchMenu()
	{
		List<LunchMenu> lLunchMenus=Arrays.asList(
                new LunchMenu(1,"White Rice",450),
                new LunchMenu(2,"Curd Rice",350),
                new LunchMenu(3,"Samber Rice",300),
                new LunchMenu(4,"Pogal Rice",400));
                
         List<LunchMenu> all=lunchMenuDao.getAllLunchMenu();
		
		 Assert.assertEquals(4, lLunchMenus.size());
	    Assert.assertEquals(lLunchMenus.size(), all.size());
		 
	}
	
	@Test
	public void testGetLunch()
	{
		LunchMenu lunchMenu=new LunchMenu();
		lunchMenu.setId(1);
		lunchMenu.setName("White Rice");
		lunchMenu.setPrice(450);
		LunchMenu lunchMenus=lunchMenuDao.getLunch(lunchMenu.getId());
		assertEquals(lunchMenu.getId(), lunchMenus.getId());
		
	}
	
	
	
	@Test
	public void testGetAllDinnerMenu()
	{
		List<DinnerMenu> lDinnerMenus=Arrays.asList(
                new DinnerMenu(1,"Egg Biryani",350),
                new DinnerMenu(2,"Mutton Biryani",600),
                new DinnerMenu(3,"Chicken Biryani",450),
                new DinnerMenu(4,"Mandi",650));
                
         List<DinnerMenu> all=dinnerMenuDao.getAllDinnerMenu();
		
		 Assert.assertEquals(4, lDinnerMenus.size());
	    Assert.assertEquals(lDinnerMenus.size(), all.size());
		 
	}
	
	@Test
	public void testGetDinner()
	{
		DinnerMenu dinnerMenu=new DinnerMenu();
		dinnerMenu.setId(4);
		dinnerMenu.setName("Mandi");
		dinnerMenu.setPrice(650);
		DinnerMenu dinnerMenus=dinnerMenuDao.getDinnerMenu(dinnerMenu.getId());
		assertEquals(dinnerMenu.getId(), dinnerMenus.getId());
		
	}
	
	
	

}
