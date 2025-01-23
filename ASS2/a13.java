package com.ASS2;
class Employee {
    private int empId;
    private String name;
    private String department;
    private double basicSalary;
    public Employee(int empId, String name, String department, double basicSalary) {
        this.empId = empId;
        this.name = name;
        this.department = department;
        this.basicSalary = basicSalary;
    }
    public int getEmpId() {
        return empId;
    }
    public String getName() {
        return name;
    }
    public String getDepartment() {
        return department;
    }
    public double getBasicSalary() {
        return basicSalary;
    }
    public double calculateSalary() {
        return basicSalary;
    }
    //Override
    public String toString() {
        return "Employee ID: " + empId +
               ", Name: " + name +
               ", Department: " + department +
               ", Basic Salary: " + basicSalary;
    }
}

// Subclass for Permanent Employee
class PermanentEmployee extends Employee {
    private double bonus;

    public PermanentEmployee(int empId, String name, String department, double basicSalary, double bonus) {
        super(empId, name, department, basicSalary);
        this.bonus = bonus;
    }

    //Override
    public double calculateSalary() {
        return getBasicSalary() + bonus;
    }
    //Override
    public String toString() {
        return super.toString() + ", Bonus: " + bonus + ", Total Salary: " + calculateSalary();
    }
}
class ContractualEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;
    public ContractualEmployee(int empId, String name, String department, double hourlyRate, int hoursWorked) {
        super(empId, name, department, 0);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
    //Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
    //Override
    public String toString() {
        return super.toString() + ", Hourly Rate: " + hourlyRate + 
               ", Hours Worked: " + hoursWorked + ", Total Salary: " + calculateSalary();
    }
}
// Department class
class Department {
    private String deptName;
    private String manager;

    public Department(String deptName, String manager) {
        this.deptName = deptName;
        this.manager = manager;
    }
    //Override
    public String toString() {
        return "Department Name: " + deptName + ", Manager: " + manager;
    }
}
// Payroll class
class Payroll {
    public static void generateReport(Employee[] employees) {
        System.out.println("Employee Payroll Report:");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}

// Main class
public class a13 {
    public static void main(String[] args) {
        Department department1 = new Department("Sales", "Anish");
        Department department2 = new Department("Mentor", "Rohit");
        Employee emp1 = new PermanentEmployee(105, "Vamsi", "Sales", 450000, 70000);
        Employee emp2 = new ContractualEmployee(100, "Dora", "Mentor", 350, 180);
        Employee[] employees = { emp1, emp2 };
        Payroll.generateReport(employees);
        System.out.println(department1);
        System.out.println(department2);
    }
}
