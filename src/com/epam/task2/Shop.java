package com.epam.task2;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Shop {
	private Map<SportEquipment, Integer> goods;
	
	public Shop(){
		goods = new HashMap<SportEquipment, Integer>();
	}
	
	
	/* Properties in the line:
	  1 - Category Code
	  2 - Category Name
	  3 - Title of the goods
	  4 - Goods price
	  5 - Number of goods 
	 */
	public Shop(String fileName){
			goods = new HashMap<SportEquipment, Integer>();
			Path path = Paths.get(fileName);
	        Scanner scanner;
			try {
				scanner = new Scanner(path);
				 while(scanner.hasNextLine()){
			           String[] unit = readUnit(scanner.nextLine());
			           SportEquipment good = new SportEquipment(new Category(unit[0],unit[1]), unit[2], unit[3]);
			           goods.put(good, Integer.parseInt(unit[4]));
			           System.out.println("");
				 }
			} catch (IOException e) {
				e.printStackTrace();
			}
	     	       
	}
	
	public String[] readUnit(String line){
		String[] unit = line.split(" ");
		return unit;
	}
	
	public void addGood(SportEquipment good,int number){
		goods.put(good, number);
	}
	
	public void showAvaliable(){
		for (Map.Entry<SportEquipment, Integer> good: goods.entrySet()){
			System.out.println(good.getKey().getInfo() + " " + good.getValue());
		}
	}
	
	public SportEquipment search(String name){
		for (Map.Entry<SportEquipment, Integer> good: goods.entrySet()){
			if(good.getKey().getTitle().equals(name)){
				return good.getKey();
			}
		}
		return null;
	}
	public boolean rent(String unitName, RentUnit listOfRented){
		if(listOfRented.getSize()>2){
			System.out.println("You cannot rent more than 3 units");
			return false;
		}
		else{
			SportEquipment unit = search(unitName);
			if (unit instanceof SportEquipment){
				if(goods.get(unit) == 0){
					System.out.println("We have no such equipment anymore. Wait till anyone bring back one of this type");
					return false;
				}
				else{
					addGood(unit, goods.get(unit)-1);
					listOfRented.addToRented(unit);
					return true;
				}
			}
			else{
				System.out.println("We have no such equipment");
				return false;
			}
		}
	}
	
	public boolean restore(String unitName, RentUnit listOfRented){
		if(listOfRented.getSize()==0){
			System.out.println("You have nothing to return");
			return false;
		}
		else{
			SportEquipment unit = search(unitName);
			if (unit instanceof SportEquipment){
				addGood(unit, goods.get(unit)+1);
				listOfRented.deleteFromRented(unit);
				return true;
			}
			else{
				System.out.println("We have no such equipment");
				return false;
			}
		}
	}
	
}
