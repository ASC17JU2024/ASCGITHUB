package accessmodifiers.p1;

public class C1P1 {
    private int privateVar = 1;
    int defaultVar = 2 ;
   public  int publicVar = 3;
   protected int protectedVar = 4 ;
   static protected int protectedStaticVar = 5;

    public static void main(String[] args) {
        C1P1 c1P1 = new C1P1();
        //The private variabe is accessibe withing the class.
        System.out.println(c1P1.privateVar);
        System.out.println(c1P1.defaultVar);
//        System.out.println(c1P1.publicVar);
//        System.out.println(c1P1.protectedVar);
    }
}
