package funda;

public class OverloadMain {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        // Call the overloaded methods
        calculator.addNum(2, 3);
        calculator.addNum(2, 3, 4);
        calculator.addNum(2.0f, 3.0f, 4.0f);
        calculator.addNum(2.0f, 3);
        calculator.addNum(2, 3.0f);
        main(10);
    }
    public static void main(int a){
        System.out.println("Overloaded main method");
    }
}

class Calculator{
    // Overloaded method with two integer parameters
    public void addNum(int a , int b){
        System.out.println("Sum of 2 int numbers is: "+(a+b));
    }
    // Overloaded method with three integer parameters
    public void addNum(int a , int b, int c){
        System.out.println("Sum of 3 int numbers is: "+(a+b+c));
    }
    // Overloaded method with three float parameters
    public void addNum(float  a , float b, float c){
        System.out.println("Sum of 3  float numbers is: "+(a+b+c));
    }
    // Overloaded method with one float and one integer parameter
    public void addNum(float a, int b){
        System.out.println("Sum of 2 float and int numbers is: "+(a+b));
    }
    public void addNum(int a, float b){
        System.out.println("Sum of 2 int and float numbers is: "+(a+b));
    }
}