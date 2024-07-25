package accessmodifiers.p2;

import accessmodifiers.p1.C1P1;

public class C4P2 extends C1P1{
    public static void main(String[] args) {
        C1P1 c1P1 = new C1P1();
//        'privateVar' has private access in 'accessmodifiers.p1.C1P1'
//        System.out.println(c1P1.privateVar);
//    'defaultVar' is not public in 'accessmodifiers.p1.C1P1'. Cannot be accessed from outside package
//        System.out.println(c1P1.defaultVar);
        System.out.println(c1P1.publicVar);
        C4P2 c4P2 = new C4P2();
        c4P2.protectedVar = 400;
     System.out.println(c4P2.protectedVar);
     System.out.println(protectedStaticVar);
    }

    public void test(){
        C1P1 c1P1 = new C1P1();
//        'privateVar' has private access in 'accessmodifiers.p1.C1P1'
//        System.out.println(c1P1.privateVar);
//    'defaultVar' is not public in 'accessmodifiers.p1.C1P1'. Cannot be accessed from outside package
//        System.out.println(c1P1.defaultVar);
        System.out.println(c1P1.publicVar);
        System.out.println(protectedVar);
    }
}
