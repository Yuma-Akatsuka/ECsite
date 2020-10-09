package model;

import java.io.Serializable;

public class CartBean implements Serializable {

	private String name;
	private int price;
	private int count;
	private int total;
	private int procd;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getProcd() {
		return procd;
	}
	public void setProcd(int procd) {
		this.procd = procd;
	}

}




