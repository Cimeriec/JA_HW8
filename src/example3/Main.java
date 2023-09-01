package example3;

public class Main implements Runnable{
    public static void main(String[] args) {
    Thread main = new Thread(new Main());
    main.setPriority(Thread.MIN_PRIORITY);
    Thread priorityRunner = new Thread(new PriorityRunner());
    priorityRunner.setPriority(Thread.NORM_PRIORITY);
    Thread priorityThread = new Thread(new PriorityThread());
    priorityThread.setPriority(Thread.MAX_PRIORITY);
    main.start();
    priorityRunner.start();
    priorityThread.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(i + " Main thread");
        }
    }
}
class PriorityRunner implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(i + " PriorityRunner thread");
        }
    }
}
class PriorityThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(i + " PriorityThread thread");
        }
    }
}
