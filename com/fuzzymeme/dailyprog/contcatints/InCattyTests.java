package com.fuzzymeme.dailyprog.contcatints;

import static org.junit.Assert.*;

import org.junit.Test;

public class InCattyTests {

	@Test
	public void test_5_56_50() {
		
		IntConcatinator catty = new IntConcatinator();
		assertEquals(50556, catty.getLowest(5, 56, 50));
		assertEquals(56550, catty.getHighest(5, 56, 50));
	}

	@Test
	public void test_79_82_34_83_69() {
		
		IntConcatinator catty = new IntConcatinator();
		assertEquals(3469798283L, catty.getLowest(79, 82, 34, 83, 69));
		assertEquals(8382796934L, catty.getHighest(79, 82, 34, 83, 69));
	}
	
	
	@Test
	public void test_420_34_19_71_341() {
		
		IntConcatinator catty = new IntConcatinator();
		assertEquals(193413442071L, catty.getLowest(420, 34, 19, 71, 341));
		assertEquals(714203434119L, catty.getHighest(420, 34, 19, 71, 341));
	}
	
	@Test
	public void test_17_32_91_7_46() {
		
		IntConcatinator catty = new IntConcatinator();
		assertEquals(173246791L, catty.getLowest(17, 32, 91, 7, 46));
		assertEquals(917463217L, catty.getHighest(17, 32, 91, 7, 46));
	}
	
	@Test
	public void test_341_31() {
		
		IntConcatinator catty = new IntConcatinator();
		assertEquals(31341L, catty.getLowest(341, 31));
		assertEquals(34131L, catty.getHighest(341, 31));
	}
	
	
	@Test
	public void test_0_1() {
		
		IntConcatinator catty = new IntConcatinator();
		assertEquals(1L, catty.getLowest(0, 1));
		assertEquals(10L, catty.getHighest(0, 1));
	}
	
}
