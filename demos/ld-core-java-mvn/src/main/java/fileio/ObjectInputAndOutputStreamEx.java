package fileio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ObjectInputAndOutputStreamEx {

    public static void main(String[] args) {
        ProductModel product1 = new ProductModel("P001", "Wings of Fire", 50.50f);
        ProductModel product2 = new ProductModel("P002", "Harry Potter", 45.00f);
        ProductModel product3 = new ProductModel("P003", "The Alchemist", 30.75f);

        // Write a single product
        writeProduct(product1);

        // Read and print a single product
        ProductModel readProduct = readProduct();
        if (readProduct != null) {
            readProduct.displayDetails();
        }

        // Write a collection of products
        ArrayList<ProductModel> productList = new ArrayList<>();
        productList.add(product2);
        productList.add(product3);
        writeProductCollection(productList);

        // Read and print all products from the collection
        ArrayList<ProductModel> readProductList = readProductCollection();
        if (readProductList != null) {
            for (ProductModel product : readProductList) {
                product.displayDetails();
            }
        }
    }

    private static void writeProduct(ProductModel product) {
        System.out.println("Writing product to file...");
        try (FileOutputStream fileOutputStream = new FileOutputStream("single_product.dat");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(product);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ProductModel readProduct() {
        System.out.println("Reading from file single_product.dat");
        try (FileInputStream fileInputStream = new FileInputStream("single_product.dat");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (ProductModel) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void writeProductCollection(ArrayList<ProductModel> products) {
        System.out.println("Writing product collection to file...");
        try (FileOutputStream fileOutputStream = new FileOutputStream("products_collection.dat");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(products);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<ProductModel> readProductCollection() {
        System.out.println("Reading from file products_collection.dat");
        try (FileInputStream fileInputStream = new FileInputStream("products_collection.dat");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            return (ArrayList<ProductModel>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}