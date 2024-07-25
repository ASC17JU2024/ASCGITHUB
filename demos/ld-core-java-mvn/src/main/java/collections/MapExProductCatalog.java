package collections;

import java.util.HashMap;
import java.util.Map;

public class MapExProductCatalog {
    static class Product {
        private String id;
        private String name;
        private double price;

        public Product(String id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
//            return "Product{" +
//                    "id='" + id + '\'' +
//                    ", name='" + name + '\'' +
//                    ", price=" + price +
//                    '}';
            return "Product ID: " + id + ", Name: " + name + ", Price: " + price;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Product> catalog = new HashMap<>();
        Product product = new Product("P004", "Smartwatch", 250.00);
        System.out.println(product);
        catalog.put("P004", product);
        product.name = "Bike";
        Product retreivedProduct =  catalog.get("P004");
        System.out.println(retreivedProduct);
        retreivedProduct.name = "Watch";
        System.out.println(retreivedProduct);
        product = new Product("P005", "Watch", 250.00);
        catalog.put("P005", product);
        catalog.put("P001", new Product("P001", "Laptop", 1200.99));
        catalog.put("P002", new Product("P002", "Smartphone", 699.49));
        catalog.put("P003", new Product("P003", "Tablet", 400.00));


//        for (Map.Entry<String, Product> entry : catalog.entrySet()) {
//            String key = entry.getKey();
//            Product value = entry.getValue();
//            System.out.println(key + ": " + value);
//        }
        
        catalog.forEach((key, value) -> System.out.println(key + ": " + value));

//        System.out.println(catalog);
    }
}