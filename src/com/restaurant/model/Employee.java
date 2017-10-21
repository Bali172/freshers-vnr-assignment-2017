package com.restaurant.model;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Employee extends EmployeeDetails {

	enum depart {
		manager, busboy, chef, server, hostess
	};

	static Scanner scanner = new Scanner(System.in);
	static List<EmployeeDetails> e = new ArrayList<EmployeeDetails>();

	/* Using queues for allotting resources required (declaration) */
	PriorityQueue<String> managers = new PriorityQueue<String>();
	PriorityQueue<String> servers = new PriorityQueue<String>();
	PriorityQueue<String> busBoys = new PriorityQueue<String>();
	PriorityQueue<String> chefs = new PriorityQueue<String>();
	PriorityQueue<String> hostess = new PriorityQueue<String>();

	public String allotManager() {

		if (managers.size() > 0) {
			return managers.poll();
		}
		printMessage("manager");
		return ("\0");
	}

	public void releaseManager(String k) {
		managers.add(k);
	}

	public String allotServer() {
		if (servers.size() > 0) {
			return servers.poll();
		}
		printMessage("server");
		return ("\0");
	}

	public void releaseServer(String k) {
		servers.add(k);
	}

	public String allotBusboy() {
		if (busBoys.size() > 0) {
			return busBoys.poll();
		}
		printMessage("busboy");
		return ("\0");
	}

	public void releaseBusboy(String k) {
		busBoys.add(k);
	}

	public String allotChef() {
		if (chefs.size() > 0) {
			return (chefs.poll());
		}

		printMessage("chefs");
		return ("\0");
	}

	public void releaseChef(String k) {
		chefs.add(k);
	}

	public String allotHostess() {
		if (hostess.size() > 0) {
			return (hostess.poll());
		}
		printMessage("hostess");
		return ("\0");
	}

	public void printMessage(String name) {
		System.out.println("Sorry,Currently any of " + name
				+ " are not available.\n\t\t\tWe regret for the inconvinience .Plese wait while we allot " + name);
	}

	public void releaseHostess(String k) {
		hostess.add(k);
	}

	public static void addUser(List<EmployeeDetails> em) {
		System.out.println("Please enter the name of the empoloyee");
		String i = scanner.next();
		System.out.println("Please provide department followed by salary ");
		String j = scanner.next();
		float k = scanner.nextFloat();

		EmployeeDetails temp = new EmployeeDetails();
		temp.employeeName = i;
		temp.department = j;
		temp.salary = k;
		em.add(temp);
	}

	public static void addUsers() {
		System.out.println("Please enter the number of people you wish to enter");
		int n = scanner.nextInt();
		while (n > 0) {
			addUser(e);
			n--;
		}
	}

	public static void displayUsers(List<EmployeeDetails> k, int n) {
		for (int i = 0; i < k.size(); i++) {
			System.out.println(
					i + "\t " + k.get(i).employeeName + "\t\t\t" + k.get(i).department + "\t\t\t" + k.get(i).salary);
		}
	}

	public static void main(String Args[]) {
		System.out.println("Welcome to the employee section .Please proceed");
		addUsers();
		displayUsers(e, e.size());
	}

}
