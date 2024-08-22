package multithreading;

public class SingleThreadedEx {
    public static void main(String[] args) {
//        PROCESS / ONE THREAD
        Thread.currentThread().setName("RJ");
        System.out.println(Thread.currentThread().getName());
        Compute compute = new Compute();
        compute.odd();
        compute.even();
    }
}
class Compute {
    public void odd() {
        for(int i = 1; i<= 50; i+=2) {
            System.out.println("ODD : " + i);
        }
    }
    public void even() {
        for(int i = 2; i<= 50; i+=2) {
            System.out.println("EVEN : " + i);
        }
    }
}