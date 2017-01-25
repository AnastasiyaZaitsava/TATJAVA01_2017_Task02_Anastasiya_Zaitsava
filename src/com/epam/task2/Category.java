package com.epam.task2;

public class Category {
	private String categoryCode;
	private String categoryName;
	
	public Category() { 
		
	}
	
	public Category(String code, String name){
		this.categoryCode = code;
		this.categoryName = name;
	}
	
	public String getCategoryCode(){
		return this.categoryCode;
	}
	
	public String getCategoryName(){
		return this.categoryName;
	}
	
	public void print(){
		System.out.print(categoryCode + " " + categoryName);
	}
}
