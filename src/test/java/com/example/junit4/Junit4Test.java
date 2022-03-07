//package com.example.junit4;
//
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Ignore;
//import org.junit.Test;
//
//public class Junit4Test 
//{
//	@BeforeClass
//	public static void beforeClass()
//	{
//		System.out.println("Open The Connection");
//	}
//	@Before
//	public void before()
//	{
//		System.out.println("refresh the page-1");
//	}
//	
//	@Test
//	//@Ignore
//	public void test1()
//	{
//		System.out.println("test1 executed");
//	}
//	@Test
//	public void test2()
//	{
//		System.out.println("test2 executed");
//	}
//	@After
//	public void after()
//	{
//		System.out.println("refresh the page-2");
//	}
//	@AfterClass
//	public static void afterClass()
//	{
//		System.out.println("Close The Connection");
//	}
//
//	@SuppressWarnings("unused")
//	@Test(expected = ArithmeticException.class)
//	public void testException()
//	{
//		int i=1/0;
//	}
//	
//}
