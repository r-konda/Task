package com.example.demo.dao;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.example.demo.model.Customer;

/*
 *  @Repository annotates classes at the persistence layer, which will act as a database repository.
 */
@Repository

/*
 * @Transactional annotation is used, 
    Spring Boot implicitly creates a proxy that will be creating a connection to the database. 
 */
@Transactional
public class CustomerDaoImpl implements CustomerDao{
	/*
	 * @Autowired annotation enables you to inject the object dependency implicitly
	 */
	  @Autowired
	  
	  //SessionFactory is an interface and SessionFactory is a factory class for Session objects..
	    private SessionFactory sessionFactory;
	 
	    public void setSessionFactory(SessionFactory sf) {
	        this.sessionFactory = sf;
	    }
	    
	    
	    @SuppressWarnings("unchecked")
		public List<Customer> getAllCustomers() 
	    {
	    	//Session is a common interface and a way of communication between java application 
	    	//and Hibernate ORM that can have one or many transactions
	    	Session session = this.sessionFactory.openSession();
	    	
	    	//A transaction is associated with Session and instantiated by calling session.beginTransaction().
	        session.beginTransaction();
			List<Customer>  customerList = session.createQuery("FROM Customer").getResultList();
			//A transaction will be started and commit after the code has been executed errorless
			//Commit a transaction by calling the commit() method on the Session interface. 
			//This tells your database to perform all required consistency checks and persist the changes permanently.
			 session.getTransaction().commit();
			 session.close();
	        return customerList; 
	    }
	 
	    public Customer getCustomer(int id) {
	        Session session = this.sessionFactory.openSession();
	        session.beginTransaction();
	        Customer customer = (Customer) session.get(Customer.class, id);
	        session.getTransaction().commit();
	        session.close();
	        return customer;
	    }
	 
	   
	    public Customer addCustomer(Customer customer) {
	        Session session = this.sessionFactory.openSession();
	        session.beginTransaction();
	        session.save(customer);
	        session.getTransaction().commit();
	        session.close();
	        return customer;
	    }
	 
	    public void updateCustomer(Customer customer) {
	        Session session = this.sessionFactory.openSession();
	        session.beginTransaction();
	        session.update(customer);
	        session.getTransaction().commit();
	        session.close();
	    }
	 
	    @SuppressWarnings("removal")
	    @Override
		public void deleteCustomer(int id) {

	        Session session = this.sessionFactory.openSession();
	        session.beginTransaction();
	        javax.persistence.Query query = session.createQuery("delete Customer where id = :num");
	        query.setParameter("num",id);
	        query.executeUpdate();
	        session.getTransaction().commit();
//	        if (null != p) {
//	            session.delete(p);
//	        }
	        session.close();
			
	    }


		@SuppressWarnings("unchecked")
		@Override
		public Integer getRecentCustomerId() {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		List<Integer> val = session.createQuery("SELECT max(id) FROM Customer").getResultList();
		session.getTransaction().commit();
		session.close();
		return !val.isEmpty() ? val.get(0) : null;
		}


		

}
