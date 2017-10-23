package com.restaurant.model;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Customers extends Employee {
	String customerName; 
	String dateOfBirth;
	static List<String> feedBackList = new ArrayList<String>();
	static int queueCount = 0;
	List<Integer> tableList = new ArrayList<Integer>();
	PriorityQueue<Integer> table2 = new PriorityQueue<Integer>();
		/*
	 * static int table2[];// Stack implemetation to allot tables
	 * 
	 * public int allotTable() { if (k == 0) { System.out.println(
	 * "Sorry for the inconvnience we are full for now." +
	 * "Please wait while we have a table available"); return (-1); } return
	 * (table2[k--]); }
	 * 
	 * public void releaseTable(int i) { table2[k]=0; if (k == 20) { System.out.
	 * println("Please use proper command as we have only 20 tables(No more tables to add)"
	 * ); } table2[k++] = i; }
	 */
	public int allotReservation(){
		return(this.table2.poll());
	}

	Employee es = new Employee();
	

	public static void main(String[] args) {
		
		Orders o = new Orders();
		o.menuList.add(new Menu(1,"Chicken-Kabab",400,"Chicken-Dry"));
		o.menuList.add(new Menu(2,"Chicken-Biryani",220,"Chicken+BasmatiRice"));
		o.menuList.add(new Menu(3,"Ferrero-Rocher",400,"Milk chocolate+Wheat-Flour+whey powder"));
		o.menuList.add(new Menu(2,"Butter-Naan",22,"Butter+WheatFLour"));
		Customers c = new Customers();
		System.out.println("Please enter your name");
		c.customerName = scanner.nextLine();
		System.out.println("Hello" + c.customerName);
		c.table2.add(1);
		c.table2.add(2);
		c.table2.add(3);
		Reservation r=new Reservation();
		
		c.releaseHostess("Hermoine");
		c.releaseManager("Bala");
		c.releaseBusboy("Tom riddle");
		c.releaseChef("Ronald weasly");
		c.releaseServer("Lucius Malfoy");
		System.out.println("\t\t\tWelcome the Hotel Sapid\n");
		
		
		int k1 = 0;
		String t;
		k1=r.checkReservation();
		if(k1!=-2){
			System.out.println("");
			System.out.println("\tWe are alloting table \n\n");	
		if(k1==-1){
		do {
			k1 = c.table2.poll();
			if (k1 != -1) {
				//System.out.println("\tTable no " + k1 + " has been alotted to you\n");
				break;
			}
		} while (c.table2.size() < 0);}
		
			System.out.println("\tTable no " + k1 + " has been alotted to you\n");
		
		t = c.allotHostess();
		if (t != "\0") {
			System.out.println("\t-Hostess " + t + " will be directing you to the table " + k1);
			c.releaseHostess(t);
		}
		t = c.allotBusboy();
		if (t != "\0") {
			System.out.println(
					"\t-Busboy " + t + " will be serving water ,mean while we will allot manger to take the order\n");
			c.releaseBusboy(t);
		}
		t = c.allotManager();
		if (t != "\0") {
			System.out.println("\t-Manager " + t + " is alotted to place your order\n");
			o.getOrders();
			c.releaseManager(t);
		}
		t = c.allotChef();
		if (t != "\0") {
			System.out.println("\t-Chef" + t + "is preparing you order\n");
			c.releaseChef(t);
		}
		System.out.println("\t\t\tYour order is ready\n");
		t = c.allotServer();
		if (t != "\0") {
			System.out.println("-Server" + t + " will be serving you order\n");
			c.releaseServer(t);
		}
		System.out.println("\tPress 1 to get bill\n");
		if (scanner.nextInt() == 1) {
			t = c.allotManager();
			if (t != "\0") {
				System.out.println("\t-Manager" + t + " will be providing bill");
				System.out.println("Total Amount for your order\t\t"+o.getBill());
				System.out.println("---------------------------------------------------------------------");
				System.out.println("Press 1 when bill was paid");
				
				if (scanner.nextInt() == 1){
					c.releaseManager(t);System.out.println("Please provide feedback");
					feedBackList.add(scanner.nextLine());}
				else
					System.out.println("Please pay you bill");
			}
			t = c.allotBusboy();
			if (t != "\0") {
				System.out.println("Busboy " + t + "has cleaned your table");
				c.releaseBusboy(t);
			}
		}
		}

			c.table2.add(k1);
			System.out.println("Thank you for visiting Hotel Mapid");

		

	}
}
