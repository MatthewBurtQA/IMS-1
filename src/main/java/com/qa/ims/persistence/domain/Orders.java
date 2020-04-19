package com.qa.ims.persistence.domain;

public class Orders {
	

	private Long id;
	private String customerID;
	private String itemsID;
	private String orderDate;
	private String orderCost;
		

	public Orders(String customerID, String orderDate, String orderCost, String itemsID) {
		this.customerID = customerID;
		this.orderDate = orderDate;
		this.orderCost = orderCost;
		this.itemsID = itemsID;
	}
	

	public Orders(Long id,String customerID, String orderDate, String orderCost, String itemsID) {
		this.id = id;
		this.customerID = customerID;
		this.orderDate = orderDate;
		this.orderCost = orderCost;
		this.itemsID = itemsID;
	}


	public Long getId() { // orderID. Should have clarified
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCustomerId() {
		return customerID;
	}
	
	public void setCustomerId(String customerID) {
		this.customerID = customerID;
	}
	
	public String getItemId() {
		return itemsID;
	}
	
	public void setItemId(String itemsID) {
		this.itemsID = itemsID;
	}
	
	public String getOrderDate() {
		return orderDate;
	}
	
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	public String getOrderCost() {
		return orderCost;
	}
	
	public void setOrderCost(String orderCost) {
		this.orderCost = orderCost;
	}
	

	public String toString() {
		return "order id: " + id + " customer id: " + customerID  + " ordered on: " + orderDate +
				" order cost: " + orderCost + " item id: " + itemsID ;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerID == null) ? 0 : customerID.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((itemsID == null) ? 0 : itemsID.hashCode());
		result = prime * result + ((orderCost == null) ? 0 : orderCost.hashCode());
		result = prime * result + ((orderDate == null) ? 0 : orderDate.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		if (customerID == null) {
			if (other.customerID != null)
				return false;
		} else if (!customerID.equals(other.customerID))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (itemsID == null) {
			if (other.itemsID != null)
				return false;
		} else if (!itemsID.equals(other.itemsID))
			return false;
		if (orderCost == null) {
			if (other.orderCost != null)
				return false;
		} else if (!orderCost.equals(other.orderCost))
			return false;
		if (orderDate == null) {
			if (other.orderDate != null)
				return false;
		} else if (!orderDate.equals(other.orderDate))
			return false;
		return true;
	}



}
