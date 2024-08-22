package multithreading;

public class MulitiThreadedEx {
    public static void main(String[] args) throws InterruptedException {
//        PROCESS / ONE THREAD
        Thread.currentThread().setName("Sanjay");
        System.out.println(Thread.currentThread().getName() + " started the competition!");
        AbhishekThread arlanThread = new AbhishekThread();
        SelvaThread janThread = new SelvaThread();
        arlanThread.start();
        janThread.start();
        System.out.println("Sleeping for some time....");
        Thread.currentThread().sleep(5000);
//        arlanThread.join();
//        janThread.join();
        System.out.println(Thread.currentThread().getName() + " announces the winner!");
    }
}

class Compute1 {
    public void odd() {
        for(int i = 1; i<= 500; i+=2) {
            System.out.println("Selva : " + i);
        }
    }
    public void even() {
        for(int i = 2; i<= 500; i+=2) {
            System.out.println("Abhishek : " + i);
        }
    }
}

class SelvaThread  extends Thread{
    @Override
    public void run() {
       Compute1 compute1 = new Compute1();
       compute1.odd();
    }
}
class AbhishekThread extends Thread{
    @Override
    public void run() {
        Compute1 compute1 = new Compute1();
        compute1.even();
    }
}