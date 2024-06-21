package accessmodifiers.p1;

public class C2P1 {
    public static void main(String[] args) {
        C1P1 c1P1 = new C1P1();
//        'privateVar' has private access in 'accessmodifiers.p1.C1P1'
//        System.out.println(c1P1.privateVar);
        System.out.println(c1P1.defaultVar);
//        System.out.println(c1P1.publicVar);
        System.out.println(c1P1.protectedVar);
//        C2P1 c2P1 = new C2P1();
//        System.out.println(c2P1.protectedVar);

    }
}
