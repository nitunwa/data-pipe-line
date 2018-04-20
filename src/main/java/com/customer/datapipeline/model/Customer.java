package com.customer.datapipeline.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private int id;
	private String name;
	List<Shopping> shopList = new ArrayList<Shopping>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Shopping> getShopList() {
		return shopList;
	}

	public void setShopList(List<Shopping> shopList) {
		this.shopList = shopList;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", shopList=" + shopList + "]";
	}

}
