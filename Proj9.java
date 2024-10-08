import java.util.*;
/**
 * Proj9.java
 * Kaleb Jaquez / Thursday / 2:30 - 4:20
 * 
 * This program allows the user to input information about employees and stores it in an ArrayList. 
 * After entering employee information, the program prompts for hours worked for hourly employees and allows deleting employees by ID.
 */
public class Proj9 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ArrayList<Employee> employeeList = new ArrayList<>();

    String input;
        
    do {
        String name = "";
        do {
            try {
                System.out.println("Enter employee's name: ");
                name = s.nextLine().trim();
                if (name.isEmpty()) {
                    throw new IllegalArgumentException("Name is required. Please re-enter.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (name.isEmpty());

        String idNumber = "";
        do {
            try {
                System.out.println("Enter " + name + "'s ID #: ");
                idNumber = s.nextLine().trim();
                if (idNumber.isEmpty()) {
                    throw new IllegalArgumentException("ID is required. Please re-enter");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (idNumber.isEmpty());

        char employeeType = ' ';
        do {
            try {
                System.out.println("Is employee S)alaried or H)ourly?");
                String userInput = s.nextLine().trim().toUpperCase();
                if (userInput.isEmpty()) {
                    throw new IllegalArgumentException("Employee Type is required. Please re-enter");
                } else if (userInput.length() != 1 || (userInput.charAt(0) != 'S' && userInput.charAt(0) != 'H')) {
                    System.out.println("Must be an 'H' or 'S'. Please re-enter");
                } else {
                    employeeType = userInput.charAt(0);
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (employeeType != 'S' && employeeType != 'H');

        double payRate = 0;
        int yearlySalary = 0;
        if (employeeType == 'H') {
            do {
                try {
                    System.out.println("Enter " + name + "'s hourly pay: ");
                    String hourlyWage = s.nextLine().trim().toUpperCase();
                    if (hourlyWage.isEmpty()) {
                        throw new IllegalArgumentException("Hourly wage needs to be specified. Please re-enter");
                    }
        //got  from google to make it simplier to have no chars  allowed in the input
                    if (!hourlyWage.matches("\\d+(\\.\\d+)?")) {
                        throw new IllegalArgumentException("No chars allowed. Enter integers or doubles only");
                    }

                    payRate = Double.parseDouble(hourlyWage);
                    if (payRate <= 0) {
                        throw new IllegalArgumentException("Hourly wage needs to be positive. Please re-enter");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                        
            } while (payRate <= 0);
        } else {
            do {
                try {
                    System.out.println("Enter " + name + "'s yearly salary: ");
                    String salaryInput = s.nextLine().trim().toUpperCase();
                    if (salaryInput.isEmpty()) {
                        throw new IllegalArgumentException("Salary needs to be positive. Please re-enter");
                    }

             //got  from google to make it simplier to have no chars or decimals allowed in the input
                    if (!salaryInput.matches("\\d+")) {
                        throw new IllegalArgumentException("No chars or decimals allowed. Enter integers only");
                    }
                    yearlySalary = Integer.parseInt(salaryInput);
                    if (yearlySalary <= 0) {
                        throw new IllegalArgumentException("Salary needs to be positive. Please re-enter");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } while (yearlySalary <= 0);
        }

        Employee employee;
        if (employeeType == 'H') {
            employee = new Employee(name, idNumber, employeeType, payRate);
        } else {
            employee = new Employee(name, idNumber, employeeType, yearlySalary);
                }

        boolean employeeExists = false;
        for (Employee existingEmployee : employeeList) {
            if (existingEmployee.getIdNumber().equals(idNumber)) {
                employeeExists = true;
                System.out.println("Duplicate employee - not added to the list");
                break;
            }
        }
        if (!employeeExists) {
            employeeList.add(employee);
        }
                
        do {
            System.out.println("Would you like to enter another employee? (Y/N):");
            input = s.nextLine();
            if (!input.equalsIgnoreCase("Y") && !input.equalsIgnoreCase("N")) {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        } while (!(input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("N")));
    } while (input.equalsIgnoreCase("Y"));

    for (Employee emp : employeeList) {
        if (emp.getEmployeeType() == 'H') {
            System.out.println("Enter hours worked for " + emp.getName() + ": ");
            double hoursWorked = 0;
            boolean validInput = false;
            do {
                try {
                    input = s.nextLine().trim();
                    hoursWorked = Double.parseDouble(input);
                    if (hoursWorked < 0) {
                        throw new IllegalArgumentException("Hours worked cannot be negative. Please re-enter.");
                    }
                    validInput = true;
                } catch (NumberFormatException e) {
                    System.out.println("No chars allowed. Enter doubles only");
                    System.out.println("Enter hours worked for " + emp.getName() + ": ");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Enter hours worked for " + emp.getName() + ": ");
                }
            } while (!validInput);
            emp.setHoursWorked(hoursWorked);
        }
    }
            

    System.out.println("Current contents of ArrayList:");
    for (Employee emp : employeeList) {
         System.out.println(emp.toString());
        System.err.println();
    }

    // Code for deleting an employee based on ID number
    String idToDelete;
    do {
        System.out.println("Enter an ID number to delete employee: ");
        idToDelete = s.nextLine().trim();
        boolean found = false;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getIdNumber().equals(idToDelete)) {
                employeeList.remove(i);
                found = true;
                System.out.println("Employee with ID#" + idToDelete + " removed from ArrayList");
                break;
            }
        }
        if (!found) {
            System.out.println("ERROR - ID # not found. Please try again");
        } else {
            break; // Exit the loop if an employee is successfully deleted
        }
    } while (true);

    // Code for printing final contents of the ArrayList
    System.out.println("Final contents of ArrayList:");
    for (Employee emp : employeeList) {
        System.out.println(emp.toString());
        System.err.println();
    }
    }
}
