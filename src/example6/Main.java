package example6;

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

        System.out.println("Thread A ");

    }
}

class B extends Thread {
    @Override
    synchronized public void run() {

        System.out.println("Thread B ");

    }
}
// 1 - Не використовувати wait, notify
