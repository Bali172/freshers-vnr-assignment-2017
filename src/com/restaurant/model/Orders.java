package com.restaurant.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Orders extends Menu {//Extending menu to reuse methods from menu

	Scanner scanner = new Scanner(System.in);
	Bill bill = new Bill();//Bill for holding single order
	List<Bill> registerList = new ArrayList<Bill>();//RegisterList to register bill
	int sno, qty, amount = 0, i = 0, k = 0;//Variables created for billing usage
		int ch;
	/*Class creation for billing*/
	public class Bill {
		ArrayList<Integer> quantity = new ArrayList<Integer>();
		ArrayList<Integer> amount = new ArrayList<Integer>();
		ArrayList<String> item = new ArrayList<String>();
		int index;
	}

	/*Push Bill to the Register for further usage*/
	public void registerBill() {
		registerList.add(k++, bill);
		registerList.get(k-1).index=bill.quantity.size();
	}
	/*To get the Bills stored in the register*/
	public void getregister() {
		for (int j = 0; j < k; j++) {
			for (int i = 0; i < registerList.get(j).index; i++)
				System.out.println(registerList.get(j).item.get(i) + "\t\t" + registerList.get(j).quantity.get(i));
		}
	}
	/*For printing Menu*/
	public void displayBill() {
		System.out.println("---------------------------------------------------------------------");
		System.out.println("Item\t\t Quantity\t\tValue");
		System.out.println("---------------------------------------------------------------------");
		for (int j = 0; j < bill.quantity.size(); j++) {
			System.out.println(bill.item.get(j) + "\t\t" + bill.quantity.get(j)+"\t\t"+bill.amount.get(j));
		}
		System.out.println("---------------------------------------------------------------------");
	}

	public void getOrders() {

		/* to display menu from the menu object array */
		displayMenu(menuList, menuList.size());

		int b_a;
		do {
			System.out.println("Please enter the serial number opposite to the item followed by Qty you wish to order");
			sno = scanner.nextInt();
			qty = scanner.nextInt();
			b_a = qty * (menuList.get(sno).getPrice());
			amount = amount + b_a;
			System.out.println("Amount for the item " + menuList.get(sno).name + "is" + b_a
					+ "and \ntotal amount of order till now " + amount);
			System.out.println("Do you want to add more to the order \n Y or N\nPress <1 to add");
			ch = scanner.nextInt();
			bill.quantity.add(qty);
			bill.item.add(menuList.get(sno).name);
			bill.amount.add(b_a);
			i++;
		} while (ch<2);
		/* to give a pre check details before finalizing order */
	}

	public int getBill() {
		displayBill();
		registerBill();
		i = 0;
		return (amount);// To give the final amount
	}

	public void changeOrder() {// method to modify order placed at any moment
		displayBill();// to display the current bill
		System.out.println("Please enter the sno followed by quantity of the Item to be removed from the menu");
		int r = scanner.nextInt();
		int j = scanner.nextInt();
		amount -= (bill.quantity.get(r) / bill.amount.get(r)) * j;
		/* for calculation individual price of an item */
		System.out.println("Modified for the bill are below \n" + "-" + bill.item.get(r) + bill.quantity.get(r) + j);// to
		/* print value after modification */
	}

	public void additem() {//To direct to add menu with number of inputs expected
		System.out.println("Please enter number of item you wish to enter");
		int choice = scanner.nextInt();
		addmenu(menuList, choice);
	}

}
