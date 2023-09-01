package example4;

public class Main {
    public static void main(String[] args) {
        Dispetcher d = new Dispetcher();
        A a = new A(d);
        B b = new B(d);
        a.start();
        b.start();
    }
}

class Dispetcher {
    boolean marker;

    synchronized void getMarker() {
        if (!marker) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("Thread B: ");
        marker = false;
        notify();
    }

    synchronized void setMarker() {
        if (marker) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("Thread A : ");
        marker = true;
        notify();
    }
}

class A extends Thread {
    Dispetcher d;

    A(Dispetcher d) {
        this.d = d;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            d.setMarker();
        }
    }
}

class B extends Thread {
    Dispetcher d;

    B(Dispetcher d) {
        this.d = d;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            d.getMarker();
        }
    }
}