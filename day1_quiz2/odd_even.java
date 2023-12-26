package com.mycompany.test;
import java.util.Scanner;
public class Test{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        System.out.println("Enter no. of elements in the String: ");
        int n=s.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter Elements: ");
        for(int i=0;i<n;i=i++){
            System.out.println("Enter for pos"+i+":");
            arr[i]=s.nextInt();
        }
        int j=0,k=0;
        int odd[]=new int[n],even[]=new int[n];
        for(int i=0;i<n;i++){
            if(arr[i]%2==0){
                even[j]=arr[i];
                j++;
            }
            else{
                odd[k]=arr[i];
                k++;
            }
        }
        System.out.print("Even Numbers: ");
        for(int i=0;i<even.length;i++){
            System.out.print(even[i]+" ");
        }
        System.out.println();
        System.out.print("Odd Numbers: ");
        for(int i=0;i<odd.length;i++){
            System.out.print(odd[i]+" ");
        }
        System.out.println();
        s.close();
    }
}
