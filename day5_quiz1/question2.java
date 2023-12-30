package day5_quiz1;
import java.util.Scanner;
class Numbers {
    private int n;
    private volatile int currentNumber = 1;
    public Numbers(int n) {
        this.n = n;
    }
    public synchronized void Number() {
        while (currentNumber <= n) {
            System.out.print(currentNumber + " ");
            currentNumber++;
            notify();
            try {
                if (currentNumber <= n) {
                    wait();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
public class question2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of N: ");
        int n = scanner.nextInt();
        Numbers printer = new Numbers(n);
        Thread thread1 = new Thread(() -> printer.Number());
        Thread thread2 = new Thread(() -> printer.Number());
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
