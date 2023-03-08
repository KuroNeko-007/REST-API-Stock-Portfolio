package com.example.demo.model;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Portfolio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private float price;
	private float chg;
	private float chgper;
	private float holdings;
	
	public Portfolio(String name, float price, float chg, float chgper, float holdings) {
		super();
		this.name = name;
		this.price = price;
		this.chg = chg;
		this.chgper = chgper;
		this.holdings = holdings;
	}
	public Portfolio() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getChg() {
		return chg;
	}
	public void setChg(float chg) {
		this.chg = chg;
	}
	public float getChgper() {
		return chgper;
	}
	public void setChgper(float chgper) {
		this.chgper = chgper;
	}
	public float getHoldings() {
		return holdings;
	}
	public void setHoldings(float holdings) {
		this.holdings = holdings;
	}
	
	 
}
