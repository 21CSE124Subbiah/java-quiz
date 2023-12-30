package day5_quiz1;
class Prime extends Thread {
    public void run() {
        for (int i = 2; i <= 10; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }
    private boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
class Palindrome extends Thread {
    public void run() {
        for (int i = 10; i <= 50; i++) {
            if (isPalindrome(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
    private boolean isPalindrome(int num) {
        int originalNum = num;
        int reverse = 0;
        while (num > 0) {
            int digit = num % 10;
            reverse = reverse * 10 + digit;
            num /= 10;
        }
        return originalNum == reverse;
    }
}
public class question3 {
    public static void main(String[] args) {
        Prime primeThread = new Prime();
        Palindrome palindromeThread = new Palindrome();
        palindromeThread.start();
         try {
            palindromeThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        primeThread.start();
    }
}
