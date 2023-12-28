/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day3_quiz1;
import java.util.Scanner;

public class question3 {
    

    public question3(int number, String message) {
        System.out.println("Number " + number + " is " + message);
    }

    private static boolean isPalindrome(int number) {
        int originalNumber = number;
        int reversedNumber = 0;

        while (number > 0) {
            int digit = number % 10;
            reversedNumber = reversedNumber * 10 + digit;
            number /= 10;
        }

        return originalNumber == reversedNumber;
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        for (int number : array) {
            String message = "";

            if (isPalindrome(number) && isPrime(number)) {
                message = "PalPrime";
            } else if (isPalindrome(number)) {
                message = "Palindrome";
            } else if (isPrime(number)) {
                message = "Prime";
            }

            new question3(number, message);
        }

        scanner.close();
    }
}
