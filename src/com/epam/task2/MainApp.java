package com.epam.task2;

import java.util.Scanner;

public class MainApp {

	public static void main(String[] args) {

		String path = "Shop.txt";
		Shop shop = new Shop(path);
		RentUnit listOfRented = new RentUnit();
		while(true){
			int action = 0;
			Scanner sc = new Scanner(System.in); 
			System.out.println("Please, enter what you want to do: "
					+ "1 - rent unit, 2 - return unit, 3 - view report about rented units, 4 - view report about avaliable units, any other symbol - exit");
			if (sc.hasNextInt()){								//if user inputs not an integer number, action will still be equal to zero
				action = sc.nextInt();
			}
			if (action == 1){
				boolean rented;
				String unit = sc.nextLine();
				System.out.println("Enter the names of units you want to rent one per row, starting every name with uppercase. Type 'end' in the end of list");
				while(sc.hasNextLine()){
					unit = sc.nextLine();
					if (unit.equals("end") || unit.equals("End")){
						break;
					}
					else {
						rented = shop.rent(unit, listOfRented);
						if (!rented){
							break;
						}
					}
				}
			}
			else if (action == 2){
				sc.nextLine();
				System.out.println("Enter the name of unit you want to return");
				shop.restore(sc.nextLine(), listOfRented);
				
			}
			else if (action == 3){
				listOfRented.showRented();
			}
			else if (action == 4){
				shop.showAvaliable();
			}
			else{					//if instruction not belongs to 1-4, program completes execution
				break;
			}
		}
	}

}
