package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class OrdersController implements CrudController<Orders>{
	

public static final Logger LOGGER = Logger.getLogger(OrdersController.class);
	
	private CrudServices<Orders> ordersService;
	
	public OrdersController(CrudServices<Orders> ordersService) {
		this.ordersService = ordersService;
	}
	

	String getInput() {
		return Utils.getInput();
	}
	
	/**
	 * Reads all customers to the logger
	 */
	@Override
	public List<Orders> readAll() {
		List<Orders> orderList = ordersService.readAll();
		for(Orders orders: orderList) {
			LOGGER.info(orders.toString());
		}
		return orderList;
	}
	/**
	 * Creates a customer by taking in user input
	 * devNote: Needs changing to fit new constructor
	 */
	@Override
	public Orders create() {
		LOGGER.info("Please enter your customer ID");
		String customerId = getInput();
		LOGGER.info("Please enter today's date ( YYYY-MM-DD )");
		String orderDate = getInput();
		LOGGER.info("Please enter the orders cost(Feature needs implementing properly)");
		String orderCost = getInput();
		LOGGER.info("Please enter item ID");
		String itemId = getInput();
		
		Orders order = ordersService.create(new Orders(customerId, orderDate, orderCost, itemId));
		LOGGER.info("order created");
		return order;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Orders update() {
		LOGGER.info("Please enter the id of the order you would like to update");
		Long id = Long.valueOf(getInput());
		LOGGER.info("Please enter a new customer ID");
		String customerID = getInput();
		LOGGER.info("Please enter a new order date");
		String orderDate = getInput();
		LOGGER.info("Please enter a new order cost (This should be auto generated)");
		String orderCost = getInput();
		LOGGER.info("Please enter a new item ID");
		String itemID = getInput();
		System.out.println("Half of this part should be automated, I'm sorry!");
		
		Orders order = ordersService.update(new Orders(id, customerID, orderDate, orderCost, itemID));
		LOGGER.info("Order Updated");
		return order;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long id = Long.valueOf(getInput());
		ordersService.delete(id);
	}
	

}
