package com.taxilla.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.taxilla.algorithms.InsertionSort;

public class TestInsertionSort 
{
	@Test
	void testSort()
	{
		int actualArr[]= {12, 11, 13, 5, 6};
		InsertionSort insertionSort=new InsertionSort();
		insertionSort.sort(actualArr);
		int expextedArr[]= {5,6,11,12,13};
		
		assertArrayEquals(expextedArr, actualArr);
		
	}
	
	@SuppressWarnings("static-access")
	@Test
	void testPrintArray()
	{
		int actualArr[]= {12, 11, 13, 5, 6};
		InsertionSort insertionSort=new InsertionSort();
		insertionSort.sort(actualArr);
		insertionSort.printArray(actualArr);
		assertNotNull(actualArr);
		
	}

}
