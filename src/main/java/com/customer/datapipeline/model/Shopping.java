package com.customer.datapipeline.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Shopping {
	private Date shoppingdate;
	private String transitId;
	List<Item> itemList = new ArrayList<Item>();

	public Date getShoppingdate() {
		return shoppingdate;
	}

	public void setShoppingdate(Date shoppingdate) {
		this.shoppingdate = shoppingdate;
	}

	public String getTransitId() {
		return transitId;
	}

	public void setTransitId(String transitId) {
		this.transitId = transitId;
	}

	@Override
	public String toString() {
		return "Shopping [shoppingdate=" + shoppingdate + ", transitId=" + transitId + ", itemList=" + itemList + "]";
	}

	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

}
