package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.qa.ims.persistence.domain.Orders;

public class OrdersDaoMysql implements Dao<Orders> {
	
	public static final Logger LOGGER = Logger.getLogger(ItemsDaoMysql.class);

	private String jdbcConnectionUrl;
	private String username;
	private String password;

	public OrdersDaoMysql(String username, String password) {
		this.jdbcConnectionUrl = "jdbc:mysql://35.205.20.221/ims";
		this.username = username;
		this.password = password;
	}

	public OrdersDaoMysql(String jdbcConnectionUrl, String username, String password) {
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
	}
	
	/**
	 * All the variables that define a customer are held below. 
	 * 
	 * @return A list of customers
	 */
	//return in orders format... sort me out chief. 
	Orders itemsFromResultSet(ResultSet resultSet) throws SQLException {
		Long id = resultSet.getLong("order_id");  
		String customerId = resultSet.getString("customer_id");
		String orderDate = resultSet.getString("order_date");
		String orderCost = resultSet.getString("order_cost");
		String itemId = resultSet.getString("item_id");
		return new Orders(id, customerId, orderDate, orderCost, itemId);
	}

	/**
	 * Reads all customers from the database
	 * 
	 * @return A list of customers
	 */
	@Override
	public List<Orders> readAll() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders");) {
			ArrayList<Orders> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(itemsFromResultSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Orders readLatest() {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY item_id DESC LIMIT 1");) {
			resultSet.next();
			return itemsFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates a customer in the database UPDATE ME WITH NEW COMPONENTS PLS. 
	 * 
	 * @param customer - takes in a customer object. id will be ignored
	 */
	@Override
	public Orders create(Orders orders) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("insert into orders(customer_id, order_date, order_cost, item_id) values('" 
				+ orders.getCustomerId() + "','" + orders.getOrderDate() + "','" + orders.getOrderCost() +
				"','" + orders.getItemId() + "')");
			
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Orders readItem(Long id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders where order_id = " + id);) {
			resultSet.next();
			return itemsFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Updates a customer in the database
	 *  also needs updating with the new variables for customer. then...rest should be fine. Omnissiah be praised.
	 * @param customer - takes in a customer object, the id field will be used to
	 *                 update that customer in the database
	 * @return
	 */
	@Override
	public Orders update(Orders orders) { // Should be done with INNER JOINS on the tables, then grab price from there. I ran out of time however. 
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("update orders set customer_id ='" + orders.getCustomerId() + "', order_date ='"
					+ orders.getOrderDate() + "', order_cost  ='" + orders.getOrderCost() + 
					 "',item_id ='" + orders.getItemId()  + "' where order_id =" + orders.getId());
			return readItem(orders.getId());
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Deletes a customer in the database
	 * 
	 * @param id - id of the customer
	 */
	@Override
	public void delete(long id) {
		try (Connection connection = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = connection.createStatement();) {
			statement.executeUpdate("DELETE FROM orders WHERE order_id = " + id);
		} catch (Exception e) {
			LOGGER.debug(e.getStackTrace());
			LOGGER.error(e.getMessage());
		}
	}

}
