package com.restaurant.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

	enum cat {
		MAINCOURSE, STARTERANDSOUP, SALADS;
	};

	// Variables to store item names with parameters for each
	String category;
	String name;
	String desc;
	int price;

	static Scanner scanner = new Scanner(System.in);

	public int getPrice() {
		return this.price;
	}

	/* Constructor invoking to null to avoid null pointer exception */
	public Menu() {
		this.category = null;
		this.name = null;
		this.price = 0;
	}

	public Menu(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}

	public Menu(String category, String name, int price) {
		this.category = category;
		this.name = name;
		this.price = price;
	}

	public static void displayMenu(List<Menu> menuList, int count) {
		for (int i = 0; i < count; i++) {
			System.out.println(i + "\t " + menuList.get(i).name + "\t\t\t" + menuList.get(i).desc + "\t\t\t" + menuList.get(i).getPrice());
		}
	}

	public static void addmenu(List<Menu> menuList, int itemCount) {
		for (int i = 0; i < itemCount; i++) {
			menuList.add(i, new Menu());

			System.out.println("Please enter Name ");
			menuList.get(i).name = scanner.next();

			System.out.println("Please enter price for the item followed by category");
			menuList.get(i).price = scanner.nextInt();

			menuList.get(i).category = scanner.next();
			System.out.println("Please enter Description ");
			menuList.get(i).desc = "";
			menuList.get(i).desc = scanner.next();
		}
	}

	public static void main(String Args[]) {
		List<Menu> menuList = new ArrayList<Menu>();
		int choice, itemCount = 0;

		do {
			System.out.println("Please 1 to enter item \n 2 to display menu \n Any number to exit");
			choice = scanner.nextInt();
			if (choice == 1) {
				System.out.println("Please enter number of item you wish to enter");
				itemCount = scanner.nextInt();
				addmenu(menuList, itemCount);
				/*
				 * for(int i=0;i<ch;i++){ m[i]=new menu(); } for(int
				 * i=0;i<ch;i++){
				 * 
				 * System.out.println("Please enter Name "); m[i].name=s.next();
				 * 
				 * System.out.
				 * println("Please enter price for the item followed by category"
				 * ); m[i].price=s.nextInt();
				 * 
				 * m[i].category=s.next();
				 * System.out.println("Please enter Description "); m[i].desc
				 * =s.next(); System.out.println(m[i].name +"\t" +m[i].desc+"\t"
				 * + m[i].price); }
				 */
			} else if (choice == 2) {
				displayMenu(menuList, itemCount);
			} else {
				System.out.println("Please enter value with in range provided");
			}

		} while (choice < 3);

		displayMenu(menuList, itemCount);
		for (int i = 0; i < itemCount; i++) {
			System.out.println(i + "\t" + menuList.get(i).name + "\t\t\t" + menuList.get(i).desc + "\t\t\t"
					+ menuList.get(i).price);
		}

	}

}
