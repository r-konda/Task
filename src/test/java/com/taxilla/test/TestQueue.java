package com.taxilla.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.taxilla.algorithms.Queue;
import com.taxilla.algorithms.StackExample;

public class TestQueue 
{
	@Test
	 void testEnqueue()
	 {
		Queue q = new Queue(5);

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        assertEquals(4, q.size());
       
       
	 }
	
	@Test
	  void testDequeue()
	 {
		Queue q = new Queue(5);

       q.enqueue(5);
       q.enqueue(2);
       q.enqueue(3);
       q.enqueue(4);
       int excepted=q.dequeue();
       assertEquals(5, excepted);
      
      
	 }
	
	@Test
	 void testPeek()
	{
		Queue q = new Queue(5);

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        
        int excepted=q.peek();
        assertEquals(1, excepted);
        
		
	}
	
	@Test
	 void testSize()
	{
		Queue q = new Queue(5);

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        
        //int excepted=q.size();
        assertNotNull(q.size());
        
        
	}
	   @Test
	    void testIsFull()
	    {
	    	
		 Queue q = new Queue(5);

	        q.enqueue(1);
	        q.enqueue(2);
	        q.enqueue(3);
	        q.enqueue(4);
	        q.enqueue(5);
	    	assertTrue(q.isFull());
	    }
	   
	   @Test
	    void testIsEmpty() 
	   {
		   Queue q = new Queue(5);
	    	//q.enqueue(1);
	    	assertTrue(q.isEmpty());
	  
		
	    }
	
	
	

    

}
