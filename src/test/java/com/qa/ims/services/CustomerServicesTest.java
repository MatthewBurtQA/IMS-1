package com.qa.ims.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.persistence.dao.Dao;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.persistence.domain.Customer;


@RunWith(MockitoJUnitRunner.class)
public class CustomerServicesTest {
	
	@Mock
	private Dao<Customer> customerDao;
	private Dao<Items> itemsDao;
	private Dao<Orders> ordersDao;
	
	@InjectMocks
	private CustomerServices customerServices;
	private ItemsServices itemsServices;
	private OrdersServices ordersServices;

	@Test
	public void customerServicesRead() {
		customerServices.readAll();
		Mockito.verify(customerDao, Mockito.times(1)).readAll();
	}

	@Test
	public void customerServicesDelete() {
		customerServices.delete(1L);
		Mockito.verify(customerDao, Mockito.times(1)).delete(1L);
	}
}
