package com.taxilla.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.taxilla.algorithms.QuickSort;

public class TestQuickSort
{
	@Test
	public void testQuickSort()
	{
		 int[] actual = {50,25,119,41,62,21,65,84,33,21};
	        int[] expected = { 21,21,25,33,41,50,62,65,84,119  };
	        QuickSort quickSort=new QuickSort();
	        quickSort.sort(actual, 0, actual.length-1);
	        Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testPartiotion()
	{
		int[] actual = {50,25,119,41,62,21,65,84,33,21};
		 QuickSort quickSort=new QuickSort();
	        quickSort.sort(actual, 0, actual.length-1);
	        quickSort.partition(actual, 2, 2);
	        quickSort.swap(actual, 2, 2);
        assertNotNull(actual);
	}
	
	@Test
	public void testPrintArray()
	{
		int[] actual = {50,25,119,41,62,21,65,84,33,21};
		 QuickSort quickSort=new QuickSort();
	        quickSort.sort(actual, 0, actual.length-1);
        quickSort.partition(actual, 2, 2);
        quickSort.swap(actual, 2, 2);
        quickSort.printArray(actual, actual.length);
        assertNotNull(actual);
       
	}

}
