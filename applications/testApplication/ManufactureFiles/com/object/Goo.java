package com.object;

public class Goo implements Iitem {

	private String name;
	private String type;
	private int price;
	private String code;
	
	public Goo()
	{
		
	}
	
	public Goo(String name, String type, int price, String code)
	{
		this.name= name;
		this.type=type;
		this.price=price;
		this.code=code;
	}
	
	@Override
	public int calculateTotal() {
		// TODO Auto-generated method stub
		return price;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
