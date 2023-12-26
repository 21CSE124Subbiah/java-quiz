package day1_quiz1;
import java.util.HashSet;
import java.util.Scanner;

public class question3 {
    public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();

        while (n != 1 && set.add(n)) {
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n /= 10;
            }
            n = sum;
        }

        return n == 1;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to check if it's a happy number: ");
        int numberToCheck = scanner.nextInt();

        boolean result = isHappy(numberToCheck);


        System.out.println(result);
    }
}
