package day5_quiz1;
class Runable implements Runnable {
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Thread Name: " + threadName);
    }
}
public class question1 {
    public static void main(String[] args) {
        Runnable Runable = new Runable();
        Thread t1 = new Thread(Runable);
        Thread t2 = new Thread(Runable);
        t1.start();
        t2.start();
    }
}
