package accessmodifiers.p1;

public class C1P1 {
    private int privateVar = 1;
     int defaultVar = 2 ;
   public  int publicVar = 3;

    public static void main(String[] args) {
        C1P1 c1P1 = new C1P1();
        System.out.println(c1P1.privateVar);
        System.out.println(c1P1.defaultVar);
        System.out.println(c1P1.publicVar);
    }
}
