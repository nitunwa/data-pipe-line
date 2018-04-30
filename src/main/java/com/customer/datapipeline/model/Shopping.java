package com.customer.datapipeline.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Shopping implements DataModel {
	private Date shoppingdate;
	private String transitId;
	List<Item> itemList = new ArrayList<Item>();
	private int id;

	public void setId(int id) {
		this.id = id;
	}

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

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

}
