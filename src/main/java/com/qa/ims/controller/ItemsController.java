package com.qa.ims.controller;

import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.services.CrudServices;
import com.qa.ims.utils.Utils;

public class ItemsController implements CrudController<Items> {

public static final Logger LOGGER = Logger.getLogger(ItemsController.class);
	
	private CrudServices<Items> itemsService;
	
	public ItemsController(CrudServices<Items> itemsService) {
		this.itemsService = itemsService;
	}
	

	String getInput() {
		return Utils.getInput();
	}
	
	/**
	 * Reads all customers to the logger
	 */
	@Override
	public List<Items> readAll() {
		List<Items> itemList = itemsService.readAll();
		for(Items items: itemList) {
			LOGGER.info(items.toString());
		}
		return itemList;
	}
	/**
	 * Creates a customer by taking in user input
	 * devNote: Needs changing to fit new constructor
	 */
	@Override
	public Items create() {
		LOGGER.info("Please enter the items name");
		String itemName = getInput();
		LOGGER.info("Please enter the items cost");
		String itemCost = getInput();
		
		Items item = itemsService.create(new Items(itemName, itemCost));
		LOGGER.info("item created");
		return item;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Items update() {
		LOGGER.info("Please enter the id of the item you would like to update");
		Long id = Long.valueOf(getInput());
		LOGGER.info("Please enter a new item name");
		String itemName = getInput();
		LOGGER.info("Please enter a new cost");
		String itemCost = getInput();
		
		Items item = itemsService.update(new Items(id, itemName, itemCost));
		//Customer customer = customerService.update(new Customer(firstName, surname, address, email, phoneNumber));

		LOGGER.info("Item Updated");
		return item;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 */
	@Override
	public void delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long id = Long.valueOf(getInput());
		itemsService.delete(id);
	}
	
}
