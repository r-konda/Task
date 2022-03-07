package com.example.demo.model;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * The @Entity annotation specifies that the class is an entity and is mapped to a database table.
 */
@Entity

/*
 * @Table annotation specifies the name of the database table to be used for mapping.
 */
@Table(name = "customer123")
public class Customer implements Serializable
{ 
	

	/*
	 * The @Id annotation specifies the primary key of an entity
	 */
	@Id
	/*
	 *  @GeneratedValue provides for the specification of generation strategies 
	 *  for the values of primary keys.
	 */
	@GeneratedValue(strategy =GenerationType.AUTO)
	
	@Column(name="customer_id")
	private int id;
	
	@Column(name="customer_name")
	private String name;
	
	@Column(name="customer_mobile_number")
	private String mobile;
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	
	public Customer(int id, String name, String mobile) {
		super();
     	this.id=id;
		this.name = name;
		this.mobile = mobile;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", mobile=" + mobile + "]";
	}

	

	
	
	
    

}
