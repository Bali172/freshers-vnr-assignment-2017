package com.restaurant.model;

public class EmployeeDetails {
	String employeeName, department;
	int did;
	float salary;
	boolean availability;

	public EmployeeDetails() {
		this.employeeName = null;
		this.department = null;
		salary = 0;
	}

	/* constructor for three parameters */
	public EmployeeDetails(String employeeName, int department, float salary) {
		this.employeeName = employeeName;
		this.department = allotdepartment(department);
		this.salary = salary;
	}

	public void employeeInternalDatabase(EmployeeDetails empDetails) {
		this.employeeName = empDetails.employeeName;
		this.department = empDetails.department;
		this.salary = empDetails.salary;
	}

	public String getName() {
		return this.employeeName;
	}

	public void setName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
public static String allotdepartment(int choice){
		
		switch(choice){
			case 1:return("Manager");
			case 2:return("Busboy");
			case 3:return("Hostess");
			case 4:return("Server");
			case 5:return("Chef");
		}
		return("\0");
	}

}
