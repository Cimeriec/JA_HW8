package example5;

public class Main {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a.start();
        b.start();
    }
}

class A extends Thread {
    @Override
    synchronized public void run() {
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread A ");
        notify();
    }
}

class B extends Thread {
    @Override
    synchronized public void run() {
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread B ");
        notify();
    }
}