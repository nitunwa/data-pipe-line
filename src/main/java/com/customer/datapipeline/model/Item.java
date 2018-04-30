package com.customer.datapipeline.model;

public class Item implements DataModel{
	private int id;
	private String name;
	private double price;
	private String catergory;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCatergory() {
		return catergory;
	}

	public void setCatergory(String catergory) {
		this.catergory = catergory;
	}

}
