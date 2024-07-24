package funda;

public class GettersSetters {
    public static void main(String[] args){
Employee employee = new Employee();
        employee.setName("John");
        employee.setAge(250);
        System.out.println(employee.getName());
        System.out.println(employee.getAge());
    }
}

class Employee{
    private int age;
     String name;

     int getAge() {
        return age;
    }

     String getName() {
        return name;
    }

     void setName(String name) {
        this.name = name;
    }

        void setAge(int age){
        if(age >21 && age < 60){
            this.age = age;
        }
       else
        {
            System.out.println("Sorry sir/mam, you are too young too experienced!");
        }
    }
}