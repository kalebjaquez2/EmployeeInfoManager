# EmployeeInfoManager
Employee Management System is a command-line Java application that allows users to manage employee information, including names, IDs, employment types (hourly or salaried), and payroll details.



## Features
- Add new employees (hourly or salaried) with detailed information such as name, ID, and pay rate/salary.
- Calculate weekly gross pay based on hours worked for hourly employees or yearly salary for salaried employees.
- Input validation for employee details (e.g., valid name, ID number, pay rate, and salary).
- Remove employees from the list by their ID.
- Display all current employees along with their calculated weekly gross pay.
- Provides error-checking and feedback for invalid inputs (e.g., incorrect data format or negative numbers).

## How to Run the Program

1. Clone the repository:
    ```bash
    git clone https://github.com/kalebjaquez2/EmployeeInfoManager.git
    ```

2. Navigate to the project directory:
    ```bash
    cd EmployeeManagementSystem
    ```

3. Compile and run the program:
    ```bash
    javac Proj9.java Employee.java
    java Proj9
    ```

## Sample Output
Enter employee's name: John Doe
Enter John's ID #: 1234
Is employee S)alaried or H)ourly? H
Enter John's hourly pay: 20
Would you like to enter another employee? (Y/N): Y

Enter employee's name: Jane Smith
Enter Jane's ID #: 5678
Is employee S)alaried or H)ourly? S
Enter Jane's yearly salary: 60000
Would you like to enter another employee? (Y/N): N

Enter hours worked for John Doe: 45
Enter hours worked for Jane Smith: (Not required for salaried employees)

Current contents of ArrayList:
--------------------------------
Name: John Doe
ID Number: 1234
Weekly Gross Pay: $950.00

Name: Jane Smith
ID Number: 5678
Weekly Gross Pay: $1,153.85
--------------------------------

Enter an ID number to delete employee: 1234
Employee with ID#1234 removed from ArrayList.

Final contents of ArrayList:
--------------------------------
Name: Jane Smith
ID Number: 5678
Weekly Gross Pay: $1,153.85
--------------------------------


## Future Improvements
- Add the ability to store employee data in a file to persist between sessions.
- Create a graphical user interface (GUI) for better user interaction.
