package com.qa.ims.persistence.domain;

public class Items {

	private Long id;
	private String itemName;
	private String itemCost;
	
	public Items(String itemName, String itemCost) {
		this.itemName = itemName;
		this.itemCost = itemCost;
	}

	public Items(Long id, String itemName, String itemCost) {
	
		this.id = id;
		this.itemName = itemName;
		this.itemCost = itemCost; 
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public String getItemCost() {
		return itemCost;
	}
	
	public void setItemCost(String itemCost) {
		this.itemCost = itemCost;
	}
	
	public String toString() {
		return "id: " + id + " item name: " + itemName + " item cost: " + itemCost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((itemCost == null) ? 0 : itemCost.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
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
		Items other = (Items) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (itemCost == null) {
			if (other.itemCost != null)
				return false;
		} else if (!itemCost.equals(other.itemCost))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		return true;
	}
	
	
	
}
