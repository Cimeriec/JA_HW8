package example7;

public class Main {
    public static void main(String[] args) {
        Daemon d = new Daemon();
        d.setDaemon(true);
        d.start();
        System.out.println("Name - " + d.getName());
        System.out.println("Priority - " + d.getPriority());
        System.out.println("Alive - " + d.isAlive());
        System.out.println("ThreadID - " + d.threadId());
    }
}

class Daemon extends Thread {
    public void run() {
        if (isDaemon()) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
