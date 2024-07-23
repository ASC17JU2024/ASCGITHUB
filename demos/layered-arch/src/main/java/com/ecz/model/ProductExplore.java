package com.ecz.model;

public class ProductExplore implements  Comparable<ProductExplore> {
    //What is a model?
    //A model is a class that represents the data in your application.
    private String id;
    private String name;
    private double price;
    private int quantity;

    public ProductExplore(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    //What is @Override?
    //The @Override annotation is used to indicate that a method is overriding a method in the superclass.
    @Override
    //What is the toString method?
    //The toString method is a method that returns a string representation of an object.
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }

    //What is equals method?
    //The equals method is a method that compares two objects for equality.
    // Try to understand the code below and answer the questions
    // What is the purpose of the equals method?
    // The purpose of the equals method is to compare two objects for equality.
    // What does the equals method do?
    // The equals method compares the id, name, price, and quantity of two Product objects for equality.
    // What is the return type of the equals method?
    // The return type of the equals method is a boolean.
    // What is the parameter of the equals method?
    // The parameter of the equals method is an Object.
    // What is the return value of the equals method?
    // The return value of the equals method is true if the two objects are equal, false otherwise.
    // What is the purpose of the if statement in the equals method?
    // The purpose of the if statement is to check if the two objects are equal based on their id, name, price, and quantity.
    // What is the purpose of the return statement in the equals method?
    // The purpose of the return statement is to return true if the two objects are equal, false otherwise.
    // What is the purpose of the else statement in the equals method?
    // The purpose of the else statement is to return false if the two objects are not equal.
    // What is the purpose of the return statement after the else statement in the equals method?
    // The purpose of the return statement after the else statement is to return false if the two objects are not equal.
    // What is the purpose of the if statement after the else statement in the equals method?
    // The purpose of the if statement after the else statement is to check if the name of the two objects is equal.
    // What is the purpose of the return statement after the if statement in the equals method?
    // The purpose of the return statement after the if statement is to return false if the name of the two objects is not equal.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductExplore product = (ProductExplore) o;

        if (Double.compare(product.price, price) != 0) return false;
        if (quantity != product.quantity) return false;
        if (id != null ? !id.equals(product.id) : product.id != null) return false;
        return name != null ? name.equals(product.name) : product.name == null;
    }

    //What is the hashCode method?
    //The hashCode method is a method that returns a hash code value for an object.
    // Try to understand the code below and answer the questions
    // What is the purpose of the hashCode method?
    // The purpose of the hashCode method is to return a hash code value for the object.
    // What is the return type of the hashCode method?
    // The return type of the hashCode method is an int.
    // What is the return value of the hashCode method?
    // The return value of the hashCode method is a hash code value for the object.
    // What is the purpose of the return statement in the hashCode method?
    // The purpose of the return statement is to return the hash code value for the object.
    // What is the purpose of the if statement in the hashCode method?
    // The purpose of the if statement is to check if the id of the object is not null.
    // What is the purpose of the return statement after the if statement in the hashCode method?
    // The purpose of the return statement after the if statement is to return the hash code value based on the id of the object.
    // What is the purpose of the else statement in the hashCode method?
    // The purpose of the else statement is to return the hash code value based on the name of the object.
    // What is the purpose of the return statement after the else statement in the hashCode method?
    // The purpose of the return statement after the else statement is to return the hash code value based on the name of the object.

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + quantity;
        return result;
    }

    //What is the compareTo method?
    //The compareTo method is a method that compares two objects based on their natural ordering.
    // Try to understand the code below and answer the questions
    // What is the purpose of the compareTo method?
    // The purpose of the compareTo method is to compare two Product objects based on their id.
    // What is the return type of the compareTo method?
    // The return type of the compareTo method is an int.
    // What is the parameter of the compareTo method?
    // The parameter of the compareTo method is a Product object.
    // What is the return value of the compareTo method?
    // The return value of the compareTo method is an int value that indicates the comparison result.
    // What is the purpose of the if statement in the compareTo method?
    // The purpose of the if statement is to check if the id of the current object is less than the id of the other object.
    // What is the purpose of the return statement after the if statement in the compareTo method?
    // The purpose of the return statement after the if statement is to return -1 if the id of the current object is less than the id of the other object.
    // What is the purpose of the else statement in the compareTo method?
    // The purpose of the else statement is to check if the id of the current object is greater than the id of the other object.
    // What is the purpose of the return statement after the else statement in the compareTo method?
    // The purpose of the return statement after the else statement is to return 1 if the id of the current object is greater than the id of the other object.
    // What is the purpose of the return statement after the else statement in the compareTo method?
    // The purpose of the return statement after the else statement is to return 0 if the id of the current object is equal to the id of the other object.
    @Override
    public int compareTo(ProductExplore o) {
        if (this.id.compareTo(o.id) < 0) {
            return -1;
        } else if (this.id.compareTo(o.id) > 0) {
            return 1;
        } else {
            return 0;
        }
    }

    //equals vs compareTo?
    //The equals method is used to compare two objects for equality, while the compareTo method is used to compare two objects based on their natural ordering.
    //When to use equals?
    //The equals method is used when you want to compare two objects for equality.
    //When to use compareTo?
    //The compareTo method is used when you want to compare two objects based on their natural ordering.
}
