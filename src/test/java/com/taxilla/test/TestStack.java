package com.taxilla.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.taxilla.algorithms.StackExample;

public class TestStack 
{
	@Test
	 void testPrintStack()
	{
		StackExample Actualstack = new StackExample(5);
		StackExample Exceptedstack = new StackExample(5);

		Actualstack.push(1);
		Actualstack.push(2);
		Actualstack.push(3);
		
		Exceptedstack.push(1);
		Exceptedstack.push(2);
		Exceptedstack.push(3);
		
		
		System.out.print("Actual Stack: ");
		Actualstack.printStack();
		System.out.println("\n");
		System.out.print("Ecexpted Stack: ");
		Exceptedstack.printStack();
		
		assertEquals(Exceptedstack.getSize(), Actualstack.getSize());
        
      }
	
	@Test
	 void testPush()
	{
		 StackExample stack = new StackExample(5);

	        stack.push(1);
	        stack.push(2);
	        stack.push(3);
	        stack.push(4);
	       assertEquals(4, stack.getSize());
	}
	
	@Test
	 void testPop()
	{
		 StackExample stack = new StackExample(5);

	        stack.push(1);
	        stack.push(2);
	        stack.push(3);
	        stack.push(4);
	        stack.push(5);
	       int excepted= stack.pop();
	       assertEquals(5, excepted);
	}
	
	@Test
	void testGetSize()
	{
		StackExample stack = new StackExample(5);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		assertEquals(3, stack.getSize());
		
	}
	
	    @Test
	    void testIsEmpty() 
	   {
	    	StackExample stack = new StackExample(5);
	    	//stack.push(1);
	    	assertTrue(stack.isEmpty());
	  
		
	    }
	    
	    @Test
	    void testIsFull()
	    {
	    	StackExample stack = new StackExample(5);
	    	stack.push(1);
	    	stack.push(2);
	    	stack.push(3);
	    	stack.push(4);
	    	stack.push(5);
	    	assertTrue(stack.isFull());
	    }
	
	

}
