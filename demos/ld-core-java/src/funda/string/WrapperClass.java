package funda.string;

public class WrapperClass {
    public static void main(String[] args) {
        byte age = 100;
        Byte bAge = new Byte(age);
        byte age1 = bAge.floatValue();
    }
}
