package day3_quiz2;
import java.util.Scanner;
public class question1 {
    
    private int a;
    private String b;
    
    public question1() {
        System.out.println("No arguments constructor called");
    }

    public question1(int value)
    {
        System.out.println("Default constructor called");
        this.a=value;
        System.out.println("The Entered Integer value is " + this.a);
        
    }


    public question1(String value1, int value2) 
    {
        System.out.println("Parameterized constructor with two arguments called");
          this.a=value2;
          this.b=value1;
        System.out.println("The Entered Integer and String value is " + this.a + " and "+this.b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       System.out.println("Choose constructor:");
       System.out.println("1. No arguments constructor \n" + "2. Default constructor \n" + "3. Parameterised constructor (can create more than one with different type of parameters)");     
       System.out.println("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                question1 obj1=new question1(); 
                break;
            case 2:
                System.out.println("Enter a Integer value:");
                int value=scanner.nextInt();
                question1 obj2=new question1(value); 
                break;
            case 3:
                System.out.println("Enter a String:");
                scanner.nextLine(); 
                String Value1=scanner.nextLine();
                System.out.println("Enter an Integer value:");
                int Value2=scanner.nextInt();
                question1 obj3=new question1(Value1, Value2);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

        scanner.close(); 
    }
}