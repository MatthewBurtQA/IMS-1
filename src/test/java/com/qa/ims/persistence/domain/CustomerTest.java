package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class CustomerTest {
	
	private Customer customer;
	private Customer other;
	
	@Before
	public void setUp() {
		//String firstName, String surname, String address, String email, String phoneNumber
		customer = new Customer("Chris", "Perrins", "somewheresvile", "email", "2112");
		//Long id, String firstName, String surname, String address, String email, String phoneNumber
		other = new Customer(1L, "ArchMagus", "BelasariusCaul", "mars", "BigBrainTech@techpriests.us", "29");
	}
	

	
	@Test
	public void equalsWithNull() {
		assertFalse(customer.equals(null));
	}
	
	@Test
	public void equalsWithDifferentObject() {
		assertFalse(customer.equals(new Object()));
	}
	
	@Test
	public void checkEquality() {
		assertTrue(customer.equals(customer));
	}

	@Test
	public void customerNameNullButOtherNameNotNull() {
		customer.setFirstName(null);
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void customerNamesNotEqual() {
		other.setFirstName("rhys");
		assertFalse(customer.equals(other));
	}
	

	
	@Test
	public void nullId() {
		customer.setId(null);
		assertFalse(customer.equals(other));
	}
	

	
	@Test
	public void otherIdDifferent() {
		other.setId(2L);
		assertFalse(customer.equals(other));
	}
	
	@Test
	public void nullSurname() {
		customer.setSurname(null);
		assertFalse(customer.equals(other));
	}
	
	

	@Test
	public void otherSurnameDifferent() {
		other.setSurname("thompson");
		assertFalse(customer.equals(other));
	}
	
	
	
	
	
}
