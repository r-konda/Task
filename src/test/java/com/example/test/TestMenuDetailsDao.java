package com.example.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.RestraurentApplication;
import com.example.demo.dao.CustomerDao;
import com.example.demo.dao.DinnerMenuDetailsDao;
import com.example.demo.dao.LunchMenuDetailsDao;
import com.example.demo.dao.MorningMenuDetailsDao;
import com.example.demo.model.Customer;
import com.example.demo.model.DinnerMenu;
import com.example.demo.model.DinnerMenuDetails;
import com.example.demo.model.LunchMenu;
import com.example.demo.model.LunchMenuDetails;
import com.example.demo.model.MorningMenu;
import com.example.demo.model.MorningMenuDetails;

@SpringBootTest(classes = RestraurentApplication.class)
@RunWith(SpringRunner.class)
@Transactional
public class TestMenuDetailsDao 
{
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private MorningMenuDetailsDao morningMenuDetailsDao;

	@Autowired
	private LunchMenuDetailsDao lunchMenuDetailsDao;

	@Autowired
	private DinnerMenuDetailsDao dinnerMenuDetailsDao;

	@Test
	
	public void testSaveMorningDetails() {
		Customer customer = new Customer();
		customer.setName("raadu");
		customer.setMobile("1325437823");

		MorningMenu morningMenu = new MorningMenu();
		morningMenu.setId(1);
		morningMenu.setName("Idli");
		morningMenu.setPrice(25);
		MorningMenuDetails morningMenuDetails = new MorningMenuDetails();
		morningMenuDetails.setCustomerDetails(customer);
		morningMenuDetails.setMorningDetails(morningMenu);

		MorningMenuDetails menuDetails = morningMenuDetailsDao.save(morningMenuDetails);
		assertThat(menuDetails.getCustomerDetails()).isNotNull();

	}

	@Test
	
	public void testGetMoriningMenu() {
		Customer customer = new Customer();
		customer.setName("Vammo");
		customer.setMobile("8374241485");
		Customer saveCustomer = customerDao.addCustomer(customer);

		MorningMenu morningMenu = new MorningMenu();
		morningMenu.setId(2);
		morningMenu.setName("Poori");
		morningMenu.setPrice(35);
		MorningMenuDetails morningMenuDetails = new MorningMenuDetails();
		morningMenuDetails.setCustomerDetails(saveCustomer);
		morningMenuDetails.setMorningDetails(morningMenu);
		morningMenuDetailsDao.save(morningMenuDetails);

		List<MorningMenuDetails> morningMenuDetail = morningMenuDetailsDao.getMorningMenu(saveCustomer);
		assertThat(morningMenuDetail.size()).isNotNull();

	}

	@Test
	
	public void testSaveLunchDetails() {
		Customer customer = new Customer();
		customer.setName("Poonu");
		customer.setMobile("996366487");

		LunchMenu lunchMenu = new LunchMenu();
		lunchMenu.setId(2);
		lunchMenu.setName("Curd Rice");
		lunchMenu.setPrice(350);
		LunchMenuDetails lunchMenuDetails = new LunchMenuDetails();
		lunchMenuDetails.setCustomerDetails(customer);
		lunchMenuDetails.setLunchDetails(lunchMenu);

		LunchMenuDetails menuDetails = lunchMenuDetailsDao.save(lunchMenuDetails);
		assertThat(menuDetails.getCustomerDetails()).isNotNull();

	}
	@Test
	public void testGetLunchMenu() {
		Customer customer = new Customer();
		customer.setName("Night");
		customer.setMobile("8374241485");
		Customer saveCustomer = customerDao.addCustomer(customer);

		LunchMenu lunchMenu = new LunchMenu();
		lunchMenu.setId(2);
		lunchMenu.setName("Curd Rice");
		lunchMenu.setPrice(350);
		LunchMenuDetails lunchMenuDetails = new LunchMenuDetails();
		lunchMenuDetails.setCustomerDetails(saveCustomer);
		lunchMenuDetails.setLunchDetails(lunchMenu);
		lunchMenuDetailsDao.save(lunchMenuDetails);

		List<LunchMenuDetails> lMenuDetails = lunchMenuDetailsDao.getLunchMenu(saveCustomer);
		assertThat(lMenuDetails.size()).isNotNull();

	}

	@Test
	public void testSaveDinnerDetails() {
		Customer customer = new Customer();
		customer.setName("Raanu");
		customer.setMobile("8789807645");

		DinnerMenu dinnerMenu = new DinnerMenu();
		dinnerMenu.setId(4);
		dinnerMenu.setName("Mandi");
		dinnerMenu.setPrice(650);
		DinnerMenuDetails dinnerMenuDetails = new DinnerMenuDetails();
		dinnerMenuDetails.setCustomerDetails(customer);
		dinnerMenuDetails.setDinnerDetails(dinnerMenu);

		DinnerMenuDetails menuDetails = dinnerMenuDetailsDao.save(dinnerMenuDetails);
		assertThat(menuDetails.getCustomerDetails()).isNotNull();

	}
	
	@Test
	public void testGetDinnerMenu() {
		Customer customer = new Customer();
		customer.setName("Donga");
		customer.setMobile("8974241485");
		Customer saveCustomer = customerDao.addCustomer(customer);

		DinnerMenu dinnerMenu = new DinnerMenu();
		dinnerMenu.setId(4);
		dinnerMenu.setName("Mandi");
		dinnerMenu.setPrice(650);
		DinnerMenuDetails dinnerMenuDetails = new DinnerMenuDetails();
		dinnerMenuDetails.setCustomerDetails(saveCustomer);
		dinnerMenuDetails.setDinnerDetails(dinnerMenu);
		dinnerMenuDetailsDao.save(dinnerMenuDetails);

		List<DinnerMenuDetails> dMenuDetails = dinnerMenuDetailsDao.getDinnerMenu(saveCustomer);
		assertThat(dMenuDetails.size()).isNotNull();

	}


}
