package com.example.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import com.example.demo.RestraurentApplication;
import com.example.demo.controller.CustomerController;
import com.example.demo.dao.CustomerDao;
import com.example.demo.model.Customer;

/*
 * The @SpringBootTest annotation loads the complete Spring application context.
 * Spring Boot provides the @SpringBootTest annotation which we can use to 
 * create an application context containing all the objects
 */
@SpringBootTest(classes = RestraurentApplication.class)
/*
 * this annotation tells JUnit to run using Spring's testing support.
 * SpringRunner is the new name for SpringJUnit4ClassRunner
 */
@RunWith(SpringRunner.class)
public class TestCustomerDao {
	@Autowired
	private CustomerDao customerDao;

	

	@Test
	public void testAddCustomer() {


		Customer savedCustomer = new Customer();
		
		savedCustomer.setMobile("9640744852");
		savedCustomer.setName("Water");
		Customer customers=customerDao.addCustomer(savedCustomer);
		
		// isGreaterThan() Verifies that the actual value is greater than the given one.

		// assertTha() the parameter is actual value.
		assertThat(customers.getName()).isNotNull();

	}

	@Test
	public void testGetAllCustomers() {

		List<Customer> products = (List<Customer>) customerDao.getAllCustomers();
		assertThat(products).size().isGreaterThan(0);
	}

	@Test
	public void testGetCustomer() 
	{
		Customer customer = customerDao.getCustomer(477);
		assertThat(customer.getId()).isEqualTo(477);
	}
	
	@Test
	public void testUpdateCustomer()
	{
		Customer customer = customerDao.getCustomer(477);
		    customer.setName("Curd");
		     
		    customerDao.updateCustomer(customer);
		     
	    Customer updatedCustomer = customerDao.getCustomer(477);
		     
		    assertThat(updatedCustomer.getName()).isEqualTo("Curd");
		
	}

	
	@Test
	public void testGetRecentCustomerId()
	{
		 Customer customer=new Customer();
		 customer.setName("Emo");
		 customer.setMobile("897645230");
		Customer addCustomer =customerDao.addCustomer(customer);
		 
	 Integer integer=customerDao.getRecentCustomerId();
		assertThat(integer).isEqualTo(addCustomer.getId());
		
	}
	
	@Test
	public void testDeleteCustomer()
	{
		try {
		
		Integer num = new Integer(548);
		customerDao.deleteCustomer(num);
		List<Customer> allCustomers = customerDao.getAllCustomers();
		Customer cust = allCustomers.stream().filter(x -> Objects.equals(x.getId(), num)).findFirst().orElse(null);
		assertThat(cust).isEqualTo(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
