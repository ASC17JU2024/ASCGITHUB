package labs;

public class Adder {
    public static void main(String[] args) {
    Adder adder = new Adder();
    adder.sum(50.5f);
    //type casting double to float
        adder.sum((float)50.5);
    }
    void sum(double d) {
        System.out.println("Double " + d);
    }
    void sum(float f) {
        System.out.println("Float " + f);

    }
}
