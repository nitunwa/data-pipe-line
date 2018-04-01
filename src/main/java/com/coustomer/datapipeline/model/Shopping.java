package com.coustomer.datapipeline.model;

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

}
