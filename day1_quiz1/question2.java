package day1_quiz1;
import java.util.Scanner;

public class question2 {
    public static void main(String[] args) {
    Scanner myObj = new Scanner(System.in);
    System.out.println("Enter the first number:");
    double num1=myObj.nextDouble();
    System.out.println("Enter the second number:");
    double num2=myObj.nextDouble();
    System.out.println("For Addition enter 1:");
    System.out.println("For subtraction enter 2:");
    System.out.println("For multiplication enter 3:");
    System.out.println("For division enter 4:");
    
    System.out.println("Enter the operator:");
    int operator=myObj.nextInt();
    switch (operator) {
     case 1:  
         double sum=num1+num2;
         System.out.println("sum :"+sum);
         break;
     case 2:
         double subtract=num1-num2;
         System.out.println("Subtraction:"+subtract);
         break;
     case 3:
         double multiply=num1*num2;
         System.out.println("Multiplication:"+multiply);
         break;
     case 4:
         if(num2==0){
             System.out.println("Division by zero is not possible"); 
         }
         double division=num1/num2;
         System.out.println("Division"+division);
         break;
    
    }
    }
}
