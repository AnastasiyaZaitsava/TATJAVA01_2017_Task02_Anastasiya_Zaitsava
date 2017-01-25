package com.epam.task2;

import java.util.ArrayList;

public class RentUnit {
	private ArrayList<SportEquipment> units;
	
	public RentUnit(){
		units = new ArrayList<SportEquipment>();
	}
	
	public void addToRented(SportEquipment unit){
		units.add(unit);
	}

	public void deleteFromRented(SportEquipment unit){
		if (units.remove(unit)){
			System.out.println("Returned");
		}
		else{
			System.out.println("You haven't rent such equipment");
		}
	}
	
	public int getSize(){
		int size = units.size();
		return size;
	}
	
	public void showRented(){
		for (SportEquipment unit: units){
			System.out.println(unit.getCategory().getCategoryName() + " " + unit.getCategory().getCategoryName() + " " + unit.getTitle() + " " + unit.getPrice());
		}
	}
}
