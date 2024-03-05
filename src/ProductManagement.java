import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ProductManagement {
    ArrayList<Product> products = new ArrayList<>();
    public void displayProducts() {
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            System.out.println("Product " + (i + 1));
            System.out.println("Code: " + p.code);
            System.out.println("Name: " + p.name);
            System.out.println("Price: " + p.price);
            System.out.println("Quantity: " + p.quantity);
            System.out.println("Description: " + p.description);
        }
    }
    public void addProduct(Scanner scanner){
        System.out.println("Enter product details:");
        // Nhập mã sản phẩm
        System.out.println("Enter product code:");
        String code = scanner.nextLine();
        // Nhập tên sản phẩm
        System.out.println("Enter product name:");
        String name = scanner.nextLine();
        // Nhập giá sản phẩm
        System.out.println("Enter product price:");
        double price = scanner.nextDouble();
        scanner.nextLine(); // Tiêu thụ ký tự newline
        // Nhập số lượng sản phẩm
        System.out.println("Enter product quantity:");
        int quantity = Integer.parseInt(scanner.nextLine());
        // Nhập mô tả sản phẩm
        System.out.println("Enter product description:");
        String description = scanner.nextLine();
        // Tạo sản phẩm mới và thêm vào danh sách
        products.add(new Product(code, name, price, quantity, description));
        System.out.println("Product added successfully.");
    }

    public void updateProduct(Scanner scanner) {
        System.out.print("Enter product code to update: ");
        String code = scanner.next();
        for (Product p : products) {
            if (p.code.equals(code)) {
                System.out.println("Enter new details:");
                System.out.print("Name: ");
                p.name = scanner.next();
                System.out.print("Price: ");
                p.price = scanner.nextDouble();
                System.out.print("Quantity: ");
                p.quantity = scanner.nextInt();
                System.out.print("Description: ");
                p.description = scanner.next();
                System.out.println("Product updated successfully.");
                return;
            }
        }
        System.out.println("Product not found.");
    }
    public void deleteProduct(Scanner scanner){
        System.out.print("Enter product code to delete: ");
        String code = scanner.nextLine();
        for (Product p : products) {
            if (p.code.equals(code)) {
                products.remove(p);
                System.out.println("Product deleted successfully.");
                return;
            }
        }
        System.out.println("Product not found.");
    }
    public void sortProducts(boolean ascending) {
        if (ascending) {
            Collections.sort(products, Comparator.comparingDouble(p -> p.price));
        } else {
            Collections.sort(products, Comparator.comparingDouble((Product p) -> p.price).reversed());
        }
        System.out.println("Products sorted successfully.");
    }
    public void findMostExpensiveProduct() {
        if (products.isEmpty()) {
            System.out.println("No products found.");
            return;
        }
        Product mostExpensive = Collections.max(products, Comparator.comparingDouble(p -> p.price));
        System.out.println("Most expensive product:");
        System.out.println("Name: " + mostExpensive.name);
        System.out.println("Price: " + mostExpensive.price);
    }

    public void readFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/products.csv"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                products.add(new Product(parts[0], parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]), parts[4]));
            }
            reader.close();
            System.out.println("Products loaded from file successfully.");
        } catch (IOException e) {
//            throw new RuntimeException(e);
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
    public void writeToFile() {
        try {
            FileWriter writer = new FileWriter("data/products.csv");
            for (Product p : products) {
                writer.write(p.code + "," + p.name + "," + p.price + "," + p.quantity + "," + p.description + "\n");
            }
            writer.close();
            System.out.println("Products written to file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

}
