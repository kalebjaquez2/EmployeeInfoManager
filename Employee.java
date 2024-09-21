/**
* Employee.java
* Kaleb Jaquez / Thursday / 2:30 - 4:20
*
* This class defines an Employee object with attributes like name, ID, type, pay rate, and yearly salary. 
* It calculates gross pay based on hours worked or yearly salary, and provides methods to retrieve and set employee information, including an equals method for ID comparison.
*/
import java.text.DecimalFormat;

public class Employee {
    private  String name;
    private String idNumber;
    private  char employeeType;
    private double payRate;
    private int yearlySalary;
    private static final int WEEKS_IN_YEAR = 52;
    private double workedHours;

/**
* Constructs an Employee object with the specified name, ID number, employee type, and pay rate.
* @param n The name of the employee
* @param i The ID number of the employee
* @param e The employee type ('H' for hourly, 'S' for salaried)
* @param p The pay rate of the employee
*/
public Employee(String n, String i, char e, double p){
    name = n;
    idNumber = i;
    employeeType = e;
    payRate = p;
    yearlySalary = -1;
}

/**
* Constructs an Employee object with the specified name, ID number, employee type, and yearly salary.
* @param n The name of the employee
* @param i The ID number of the employee
* @param e The employee type ('H' for hourly, 'S' for salaried)
* @param y The yearly salary of the employee
*/
public Employee(String n, String i, char e, int y){
    name = n;
    idNumber = i;
    employeeType = e;
    payRate = -1;
    yearlySalary = y;
}

/**
* Calculates the gross pay for the employee based on the number of hours worked.
* @param hoursWorked The number of hours worked by the employee
* @return The weekly gross pay for the employee
*/
public double getGrossPay(double hoursWorked){
    double weeklyPay;
    if(hoursWorked <= 40){
        weeklyPay = hoursWorked * payRate;
    }
    else{
        double regularPay = 40 * payRate;
        double overtimePay = (hoursWorked - 40) * (payRate *1.5);
        weeklyPay = regularPay + overtimePay;
    }
    return weeklyPay;
}

/**
* Calculates the gross pay for the employee based on the yearly salary.
* @return The weekly gross pay for the employee
*/
public double getGrossPay(){
    double weeklySalary = (double)yearlySalary / WEEKS_IN_YEAR;
    DecimalFormat df = new DecimalFormat("#,##0.00");
    return Double.parseDouble(df.format(weeklySalary).replaceAll(",", ""));
}

/**
* Retrieves the ID number of the employee.
* @return The ID number of the employee
*/
public String getIdNumber(){
    return idNumber;
}

/**
* Retrieves the name of the employee.
* @return The name of the employee
*/
public String getName(){
    return name;
}

/**
* Returns a string representation of the employee.
* @return A string containing the name, ID number, and weekly gross pay of the employee
*/
public String toString(){
    double weeklyGrossPay = (employeeType == 'H') ? payRate * workedHours : getGrossPay();
    return "Name: " + name + "\nID Number: " + idNumber + "\nWeekly Gross Pay: $" + String.format("%.2f", weeklyGrossPay);
}

/**
* Retrieves the employee type.
* @return The employee type ('H' for hourly, 'S' for salaried)
*/
public char getEmployeeType(){
    return employeeType;
}

/**
* Sets the number of hours worked by the employee.
* @param wh The number of hours worked
*/
public void setHoursWorked(double wh) {
    workedHours = wh;
}

/**
* Checks if this employee is equal to another employee based on their ID numbers.
* @param e The other employee to compare
* @return true if the employees have the same ID number, otherwise false
*/
public boolean equals(Employee e){
    return idNumber.equals(e.idNumber);
}
}
