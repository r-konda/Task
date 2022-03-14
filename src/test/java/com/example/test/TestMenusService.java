package com.example.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.RestraurentApplication;
import com.example.demo.dao.CustomerDao;
import com.example.demo.dao.DinnerMenuDao;
import com.example.demo.dao.DinnerMenuDetailsDao;
import com.example.demo.dao.LunchMenuDao;
import com.example.demo.dao.LunchMenuDetailsDao;
import com.example.demo.dao.MorningMenuDao;
import com.example.demo.dao.MorningMenuDetailsDao;
import com.example.demo.model.Customer;
import com.example.demo.model.DinnerMenu;
import com.example.demo.model.DinnerMenuDetails;
import com.example.demo.model.LunchMenu;
import com.example.demo.model.LunchMenuDetails;
import com.example.demo.model.MorningMenu;
import com.example.demo.model.MorningMenuDetails;
import com.example.demo.model.TotalOrder;
import com.example.demo.service.DinnerMenuService;
import com.example.demo.service.LunchMenuService;
import com.example.demo.service.MorningMenuService;

@SpringBootTest(classes = RestraurentApplication.class)
@RunWith(SpringRunner.class)

public class TestMenusService {
	@Autowired
	private MorningMenuService morningMenuService;

	@Autowired
	private LunchMenuService lunchMenuService;

	@Autowired
	private DinnerMenuService dinnerMenuService;

	@Autowired
	private CustomerDao customerDao;

	@Autowired
	private MorningMenuDao morningMenuDao;

	@Autowired
	private LunchMenuDao lunchMenuDao;

	@Autowired
	private MorningMenuDetailsDao morningMenuDetailsDao;

	@Autowired
	private LunchMenuDetailsDao lunchMenuDetailsDao;

	@Autowired
	private DinnerMenuDao dinnerMenuDao;

	@Autowired
	private DinnerMenuDetailsDao dinnerMenuDetailsDao;

	@Test
	public void testGetDiscountApplicableCustomersForLunchMenu() {
		List<Customer> list = lunchMenuService.getDiscountApplicableCustomers();

		// isGreaterThan() Verifies that the actual value is greater than the given one.

		// assertTha() the parameter is actual value.
		assertThat(list).size().isGreaterThan(0);

	}

	@Test
	public void testGetDiscountApplicableCustomersForMorningMenu() {
		List<Customer> list = morningMenuService.getDiscountApplicableCustomers();
		// isGreaterThan() Verifies that the actual value is greater than the given one.

		// assertTha() the parameter is actual value.
		assertThat(list).size().isGreaterThan(0);

	}

	@Test
	public void testGetDiscountApplicableCustomersForDinnerMenu() {

		List<Customer> list = dinnerMenuService.getDiscountApplicableCustomers();
		System.out.println(list);
		// isGreaterThan() Verifies that the actual value is greater than the given one.

		// assertTha() the parameter is actual value.
		assertThat(list).size().isGreaterThan(0);

	}

	@Test
	public void testSaveMorningMenuDetails() {
		Customer customer = new Customer();
		customer.setName("Emo");
		customer.setMobile("897645230");
		customerDao.addCustomer(customer);
		Customer cust = this.customerDao.getCustomer(this.customerDao.getRecentCustomerId());

		MorningMenu menu1 = new MorningMenu(1, "Idli", 25);
		MorningMenu menu2 = new MorningMenu(2, "Poori", 35);
		MorningMenu menu3 = new MorningMenu(3, "Upma", 40);
		MorningMenu menu4 = new MorningMenu(4, "Dosa", 45);

		MorningMenu morningMenus = morningMenuDao.getMorning(menu1.getId());

		MorningMenuDetails menuDetails = new MorningMenuDetails();
		menuDetails.setMorningDetails(morningMenus);
		menuDetails.setCustomerDetails(cust);
		MorningMenuDetails saveMorningMenuDetails = morningMenuDetailsDao.save(menuDetails);
		
		//Test will pass
		assertThat(saveMorningMenuDetails.getId()).isNotNull();
		
		//Test will fail
	    //assertThat(saveMorningMenuDetails.getId()).isNull();
		

	}

	@Test
	public void testGetAllMorningMenuList() {
		List<MorningMenu> morningMenusList = Arrays.asList(new MorningMenu(1, "Idli", 25),
				new MorningMenu(2, "Poori", 35), new MorningMenu(3, "Upma", 40), new MorningMenu(4, "Dosa", 45));

		List<MorningMenu> list = morningMenuService.getAllMorningMenuList();

		// Test Will Pass
		assertEquals(morningMenusList.size(), list.size());

		// Test will fail
		// assertEquals(morningMenusList.size(), list.size()-1);

	}

	@Test
	public void testSaveLunchMenuDetails() {
		Customer customer = new Customer();
		customer.setName("Bairi Lingaiah");
		customer.setMobile("8096071252");
		customerDao.addCustomer(customer);
		Customer cust = this.customerDao.getCustomer(this.customerDao.getRecentCustomerId());

		LunchMenu menu1 = new LunchMenu(1, "White Rice", 450);
		LunchMenu menu2 = new LunchMenu(2, "Curd Rice", 350);
		LunchMenu menu3 = new LunchMenu(3, "Samber Rice", 300);
		LunchMenu menu4 = new LunchMenu(4, "Pogal Rice", 400);

		LunchMenu lunchMenus = lunchMenuDao.getLunch(menu2.getId());
		LunchMenuDetails menuDetails = new LunchMenuDetails();
		menuDetails.setLunchDetails(lunchMenus);
		menuDetails.setCustomerDetails(cust);
		LunchMenuDetails saveLunchMenuDetails = lunchMenuDetailsDao.save(menuDetails);
		
		//Test will pass
		assertThat(saveLunchMenuDetails.getId()).isNotNull();
		
		//Test will fail
		//assertThat(saveLunchMenuDetails.getId()).isNull();
				
	}

	@Test
	public void testGetAllLunchMenuList() {
		List<LunchMenu> lLunchMenus = Arrays.asList(new LunchMenu(1, "White Rice", 450),
				new LunchMenu(2, "Curd Rice", 350), new LunchMenu(3, "Samber Rice", 300),
				new LunchMenu(4, "Pogal Rice", 400));

		List<LunchMenu> list = lunchMenuService.getAllLunchMenuList();

		// Test will pass
		assertEquals(lLunchMenus.size(), list.size());

		// Test will fail
		// assertEquals(lLunchMenus.size(), list.size()-1);

	}

	@Test
	public void testSaveDinnerMenuDetails() {
		Customer customer = new Customer();
		customer.setName("Bairi Lingaiah");
		customer.setMobile("8096071252");
		customerDao.addCustomer(customer);
		Customer cust = this.customerDao.getCustomer(this.customerDao.getRecentCustomerId());

		DinnerMenu menu1 = new DinnerMenu(1, "Egg Biryani", 350);
		DinnerMenu menu2 = new DinnerMenu(2, "Mutton Biryani", 600);
		DinnerMenu menu3 = new DinnerMenu(3, "Chicken Biryani", 450);
		DinnerMenu menu4 = new DinnerMenu(4, "Mandi", 650);

		DinnerMenu dinnerMenus = dinnerMenuDao.getDinnerMenu(menu4.getId());

		DinnerMenuDetails menuDetails = new DinnerMenuDetails();
		menuDetails.setDinnerDetails(dinnerMenus);
		menuDetails.setCustomerDetails(cust);
		DinnerMenuDetails saveDinnerMenuDetails = dinnerMenuDetailsDao.save(menuDetails);
		
		//Test will pass
		assertThat(saveDinnerMenuDetails.getId()).isNotNull();
		
		//Test will fail
		//assertThat(saveDinnerMenuDetails.getId()).isNull();
		

	}

	@Test
	public void testGetAllDinnerMenuList() {
		List<DinnerMenu> lDinnerMenus = Arrays.asList(new DinnerMenu(1, "Egg Biryani", 350),
				new DinnerMenu(2, "Mutton Biryani", 600), new DinnerMenu(3, "Chicken Biryani", 450),
				new DinnerMenu(4, "Mandi", 650));

		List<DinnerMenu> list = dinnerMenuService.getAllDinnerMenuList();

		// Test will pass
		assertEquals(lDinnerMenus.size(), list.size());

		// Test will fail
		// assertEquals(lDinnerMenus.size(), list.size()-1);

	}

}
