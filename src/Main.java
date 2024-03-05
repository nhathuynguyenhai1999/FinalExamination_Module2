import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManagement pm = new ProductManagement();
        while (true) {
            System.out.println("\n==== MENU ====");
            System.out.println("1. View products");
            System.out.println("2. Add new product");
            System.out.println("3. Update product");
            System.out.println("4. Delete product");
            System.out.println("5. Sort products");
            System.out.println("6. Find most expensive product");
            System.out.println("7. Read from file");
            System.out.println("8. Write to file");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    pm.displayProducts();
                    break;
                case 2:
                    pm.addProduct(scanner);
                    break;
                case 3:
                    pm.updateProduct(scanner);
                    break;
                case 4:
                    pm.deleteProduct(scanner);
                    break;
                case 5:
                    System.out.print("Sort in ascending order? (true/false): ");
                    String sortChoice = scanner.nextLine();
                    boolean ascending = scanner.nextBoolean();
                    pm.sortProducts(ascending);
                    break;
                case 6:
                    pm.findMostExpensiveProduct();
                    break;
                case 7:
                    pm.readFromFile();
                    break;
                case 8:
                    pm.writeToFile();
                    break;
                case 9:
                    System.out.println("Exiting program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}