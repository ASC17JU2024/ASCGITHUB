package multithreading;

public class MulitiThreadedEx {
    public static void main(String[] args) throws InterruptedException {
//        PROCESS / ONE THREAD
        Thread.currentThread().setName("Sanjay");
        System.out.println(Thread.currentThread().getName() + " started the competition!");
        AbhishekThread abhishekThread = new AbhishekThread();
        SelvaThread selvaThread = new SelvaThread();
//        abhishekThread.start();
        Thread abhishekThread1 = new Thread(abhishekThread);
        abhishekThread1.start();
        selvaThread.start();
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
class AbhishekThread implements Runnable{
    @Override
    public void run() {
        Compute1 compute1 = new Compute1();
        compute1.even();
    }
}