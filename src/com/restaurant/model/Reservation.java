package com.restaurant.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.restaurant.model.Orders.Bill;

public class Reservation extends Customers {
	Scanner scanner = new Scanner(System.in);
	int reservationnumber;
	String mobilenumber;
	List<Reservation> reservationList=new ArrayList<Reservation>();


	public Reservation(int reservationnumber,String mobilenumber) {
		this.reservationnumber=reservationnumber;
		this.mobilenumber=mobilenumber;
		// TODO Auto-generated constructor stub'
	}
	public Reservation(){
		
	}
	
	public int getReservation(String s){
		int count=reservationList.size();
		while(count>0){
			if((reservationList.get(count).mobilenumber)==s){
				return(reservationList.get(count).reservationnumber);
			}
			count--;
		}
		System.out.println("Sorry your Numberdoesnot have any table reserved we will be directing you to regular table allotment");
		return(-1);
	}
	Customers r=new Customers();
	
	public int checkReservation(){
		r.table2.add(4);
		r.table2.add(5);
		System.out.println("Do you have Reservation?");
		System.out.println("Press 1 if you have reservation\nPress 2 if you want to Reserve table\n Press 3 to move to skip");
		int choice=scanner.nextInt();
		if(choice==1){
			System.out.println("Please enter your Reservation ID(mobile number)");
			String s=scanner.next();
			return getReservation(s);
		}
		if(choice==2){
			System.out.println("Plese enter your mobile number");
			String s=scanner.next();			
			int a=r.table2.poll();
			System.out.println("Your reservation table "+a);
			reservationList.add(new Reservation(a,s));
			return(-2);
			
		}
		return(-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
