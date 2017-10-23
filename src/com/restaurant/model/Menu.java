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

	public Menu(int category, String name, int price,String desc) {
		this.category = categerize(category);
		this.name = name;
		this.price = price;
		this.desc=desc;
	}
/*Method to Display the Menu*/
	public static void displayMenu(List<Menu> menuList, int count) {
		for (int i = 0; i < menuList.size(); i++) {
			
			System.out.println(i + "\t " + menuList.get(i).name +  "\t\t\t" + menuList.get(i).getPrice()+"\t\t\t\t" + menuList.get(i).desc );
		}
	}
	/*To allot category to Menu item*/
	public static String categerize(int choice){
		
		switch(choice){
			case 1:return("Starter");
			case 2:return("Maincourse");
			case 3:return("Salads");
		}
		return("\0");
	}
	List <Menu> starterCat=new ArrayList<Menu>();
	List <Menu> mainCourseCat=new ArrayList<Menu>();
	List <Menu> saladsCat=new ArrayList<Menu>();

	/*To add Items to the menu*/
	public static void addmenu(List<Menu> menuList, int itemCount) {
		int lengthHolder=menuList.size();
		for (int i = lengthHolder; i <lengthHolder+ itemCount; i++) {
			menuList.add(i, new Menu());

			System.out.println("Please enter Name ");
			menuList.get(i).name = scanner.next();

			System.out.println("Please enter price for the item");
			menuList.get(i).price = scanner.nextInt();
			System.out.println("Please Select the category of the Item");
			System.out.println("Press \n 1\tStarter and Soup\n 2\tMain Course\n 3\tSalads");
			menuList.get(i).category = categerize(scanner.nextInt());
			System.out.println("Please enter Description ");
			menuList.get(i).desc = "";
			menuList.get(i).desc = scanner.next();
		}
	}


	static List<Menu> menuList = new ArrayList<Menu>();
	public static void main(String Args[]) {
		
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
