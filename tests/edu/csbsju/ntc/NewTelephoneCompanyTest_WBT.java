package edu.csbsju.ntc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NewTelephoneCompanyTest_WBT {
	private NewTelephoneCompany ntc;

	@Before
	public void setUp() throws Exception {
		ntc = new NewTelephoneCompany();
	}

	@Test(expected=UnsupportedOperationException.class)
	public void testComputeCharge_InvalidStartTime() {
		ntc.setStartTime(-5);
	    ntc.setDuration(10);
	    ntc.computeCharge();
		
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testComputeCharge_InvalidDuration() {
		ntc.setStartTime(1800);
	    ntc.setDuration(0);
	    ntc.computeCharge();
		
	}
	
	@Test
	public void testComputeCharge_BothDiscounts() {
		ntc.setStartTime(500);
	    ntc.setDuration(100);
	    ntc.computeCharge();
	    double expResult = 1768;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());
		 
	}
	
	@Test
	public void testComputeCharge_StartTimeDiscount() {
		ntc.setStartTime(0);
	    ntc.setDuration(60);
	    ntc.computeCharge();
	    double expResult = 1248; //add a one at the begining to see what happens
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());
		
	} 
	 
	@Test
	public void testComputeCharge_DurationDiscount() {
		ntc.setStartTime(800);
	    ntc.setDuration(65);
	    ntc.computeCharge();
	    double expResult = 2298.4;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());
		 
	}
	
	@Test
	public void testComputeCharge_NoDiscounts() {
		ntc.setStartTime(1000);
	    ntc.setDuration(40);
	    ntc.computeCharge();
	    double expResult = 1664;
	    assertTrue("A call starting at " + ntc.getStartTime() + " for a duration of " + ntc.getDuration()+ expResult,expResult==ntc.computeCharge());
	}

}
