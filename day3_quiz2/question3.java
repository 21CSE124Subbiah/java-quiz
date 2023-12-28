package day3_quiz2;
import java.util.Scanner;

public class question3 {
    
private int[] arr;
    private int count;

    // Constructor to take user input for the array size and elements
    public question3() {
        Scanner scanner=new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size=scanner.nextInt();
        arr=new int[size];

        System.out.println("Enter the elements:");
        for (int i=0;i<size;i++) 
        {
            arr[i]=scanner.nextInt();
        }

        scanner.close();

        remove_duplicate();
    }

    private void remove_duplicate() 
    {
        if (arr.length==0) 
        {
            count=0;
            return;
        }

        count=1; 
        for (int i=1;i<arr.length; i++) 
        {
            if (arr[i]!=arr[i-1]) 
            {
                arr[count]=arr[i];
                count++;
            }
        }
    }

    public int count() 
    {
        return count;
    }

    public static void main(String[] args) 
    {
        question3 obj=new question3();
        System.out.println("Number of unique elements: " + obj.count());
    }
}