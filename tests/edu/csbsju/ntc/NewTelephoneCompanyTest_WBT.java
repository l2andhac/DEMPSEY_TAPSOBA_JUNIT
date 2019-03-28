package edu.csbsju.ntc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NewTelephoneCompanyTest_WBT {
	private NewTelephoneCompany ntc;
	@Before
	public void testSetUp() throws Exception {
		ntc = new NewTelephoneCompany();
	}

	@Test (expected = UnsupportedOperationException.class)
	public void testComputeChargeInvalidStartTime() {
		ntc.setStartTime(-5);
		ntc.setDuration(10);
		ntc.computeCharge();
	}
	
	@Test (expected = UnsupportedOperationException.class)
	public void testComputeChargeInvalidDuration() {
		ntc.setStartTime(1800);
		ntc.setDuration(0);
		ntc.computeCharge();
	}

	@Test 
	public void testComputeChargeDiscountedSTAndDuration() {
		ntc.setStartTime(500);
		ntc.setDuration(100);
		double expected = 1768.0;
		double actual = ntc.computeCharge();
		assertTrue("A call starting at " + ntc.getStartTime() + " with a duration of " 
		+ ntc.getDuration() + "equals: " + expected, expected == actual);
	}
	
	@Test 
	public void testComputeChargeDiscountedST() {
		ntc.setStartTime(759);
		ntc.setDuration(1);
		double expected = 20.8;
		double actual = ntc.computeCharge();
		assertTrue("A call starting at " + ntc.getStartTime() + " with a duration of " 
		+ ntc.getDuration() + "equals: " + expected, expected == actual);
	}
	
	@Test 
	public void testComputeChargeDiscountedDuration() {
		ntc.setStartTime(800);
		ntc.setDuration(65);
		double expected = 2298.4;
		double actual = ntc.computeCharge();
		assertTrue("A call starting at " + ntc.getStartTime() + " with a duration of " 
		+ ntc.getDuration() + "equals: " + expected, expected == actual);
	}
	
	@Test 
	public void testComputeChargeNoDiscounts() {
		ntc.setStartTime(801);
		ntc.setDuration(59);
		double expected = 2454.4;
		double actual = ntc.computeCharge();
		assertTrue("A call starting at " + ntc.getStartTime() + " with a duration of " 
		+ ntc.getDuration() + "equals: " + expected, expected == actual);
	}

}
