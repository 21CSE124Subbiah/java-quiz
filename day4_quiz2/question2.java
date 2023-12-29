import java.util.Scanner;

class Employee 
{
    private String name;
    private int employeeID;

    public Employee(String name, int employeeID) 
    {
        this.name = name;
        this.employeeID = employeeID;
    }

    public String getName()
    {
        return name;
    }

    public int getEmployeeID() 
    {
        return employeeID;
    }

    public double calculateSalary() 
    {
        return 50000.0; 
    }
}

class Manager extends Employee 
{
    private double bonusPercentage;

    public Manager(String name, int employeeID, double bonusPercentage) 
    {
        super(name, employeeID);
        this.bonusPercentage = bonusPercentage;
    }

    @Override
    public double calculateSalary() 
    {
        double basicSalary = super.calculateSalary();
        return basicSalary + (basicSalary * bonusPercentage / 100);
    }
}

class Developer extends Employee 
{
    private String programmingLanguage;

    public Developer(String name, int employeeID, String programmingLanguage) 
    {
        super(name, employeeID);
        this.programmingLanguage = programmingLanguage;
    }

    public double calculateSalary() 
    {
        double basicSalary = super.calculateSalary();
        return basicSalary + 5000.0; // Extra allowance for developers is $5,000
    }
}

public class EmployeeDemo 
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a Manager instance with user input
        System.out.print("Enter Manager's name: ");
        String managerName = scanner.nextLine();

        System.out.print("Enter Manager's employee ID: ");
        int managerID = scanner.nextInt();

        System.out.print("Enter Manager's bonus percentage: ");
        double bonusPercentage = scanner.nextDouble();

        Manager manager = new Manager(managerName, managerID, bonusPercentage);

        // Create a Developer instance with user input
        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter Developer's name: ");
        String developerName = scanner.nextLine();

        System.out.print("Enter Developer's employee ID: ");
        int developerID = scanner.nextInt();

        scanner.nextLine(); // Consume the newline character
        System.out.print("Enter Developer's programming language: ");
        String programmingLanguage = scanner.nextLine();

        Developer developer = new Developer(developerName, developerID, programmingLanguage);

        // Close the Scanner
        scanner.close();

        // Display details and calculate salaries
        System.out.println("\nManager Details:");
        displayEmployeeDetails(manager);
        System.out.println("Calculated Salary: $" + manager.calculateSalary());

        System.out.println("\nDeveloper Details:");
        displayEmployeeDetails(developer);
        System.out.println("Calculated Salary: $" + developer.calculateSalary());
    }

    private static void displayEmployeeDetails(Employee employee) {
        System.out.println("Name: " + employee.getName());
        System.out.println("Employee ID: " + employee.getEmployeeID());
    }
}
