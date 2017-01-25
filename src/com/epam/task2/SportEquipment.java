package com.epam.task2;

public class SportEquipment {
	private Category category;
	private String title;
	private int price;

	public SportEquipment(){
		
	}
	
	public SportEquipment(Category cat, String title, String price){
		this.category = cat;
		this.title = title;
		this.price = Integer.parseInt(price);
	}

	public String getTitle(){
		return this.title;
	}
	
	public int getPrice(){
		return this.price;
	}
	
	public Category getCategory(){
		return this.category;
	}
	
	public String getInfo(){
		String info = this.category.getCategoryCode() + " " + this.category.getCategoryName() + " " + this.getTitle() + " Price:" + this.getPrice();
		return info;
	}
}
