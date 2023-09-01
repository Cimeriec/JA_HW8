package example2;

public class Main extends Thread{
    public static void main(String[] args) {
    Thread main = new Thread(new Main());
    Thread first = new Thread(new First());
    Thread second = new Thread(new Second());
    main.start();
    first.start();
    second.start();
    }
    @Override
    public void run(){
        System.out.println("Main thread");
    }
}
class First extends Thread{
    @Override
    public void run(){
        System.out.println("First thread");
    }
}
class Second extends Thread{
    @Override
    public void run(){
        System.out.println("Second thread");
    }
}