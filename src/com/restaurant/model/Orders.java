package com.restaurant.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Orders extends Menu {

	Scanner s = new Scanner(System.in);
	Bill bill = new Bill();
	List<Bill> registerList = new ArrayList<Bill>();
	int sno, qty, amount = 0, i = 0, k = 0;
	static List<Menu> menuList = new ArrayList<Menu>();
	String ch;

	public class Bill {
		int q[], a[], index = 0;;
		String[] item;
	}

	public void registerBill() {
		registerList.add(k++, bill);
		registerList.get(k).index = i;
	}

	public void getregister() {
		for (int j = 0; j < k; j++) {
			for (int i = 0; i < registerList.get(j).index; i++)
				System.out.println(registerList.get(j).item[i] + "\t\t" + registerList.get(j).q[i]);
		}
	}

	public void displayBill() {
		System.out.println("Item\t\t Quantity");
		for (int j = 0; j < i; j++) {
			System.out.println(bill.item[i] + "\t\t" + bill.q[i]);
		}
	}

	public void getOrders() {

		/* to display menu from the menu object array */
		displayMenu(menuList, menuList.size());

		int b_a;
		do {
			System.out.println("Please enter the serial number opposite to the item followed by Qty you wish to order");
			sno = s.nextInt();
			qty = s.nextInt();
			b_a = qty * (menuList.get(sno).getPrice());
			amount = amount + b_a;
			System.out.println("Amount for the item " + menuList.get(sno).name + "is" + b_a
					+ "and total amount of order till now" + amount);
			System.out.println("Do you want to add more to the order \n Y or N");
			ch = s.next();
			bill.q[i] = qty;
			bill.item[i] = menuList.get(sno).name;
			bill.a[i] = b_a;
			i++;
		} while ((ch == "y") || (ch == "Y") || (ch == "Yes") || (ch == "yes"));
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
		int r = s.nextInt();
		int j = s.nextInt();
		amount -= (bill.q[r] / bill.a[r]) * j;
		/* for calculation individual price of an item */
		System.out.println("Modified for the bill are below \n" + "-" + bill.item[r] + bill.q[r] + j);// to
		/* print value after modification */
	}

	public void additem() {
		System.out.println("Please enter number of item you wish to enter");
		int choice = s.nextInt();
		addmenu(menuList, choice);
	}

}
