import java.util.HashMap;
import java.util.Scanner;

public class InventoryManagement {
    private static HashMap<String, Integer> inventory = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        System.out.println("=== Inventory Management System ===");

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add item");
            System.out.println("2. View inventory");
            System.out.println("3. Update item quantity");
            System.out.println("4. Delete item");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1: addItem(); break;
                case 2: viewInventory(); break;
                case 3: updateItem(); break;
                case 4: deleteItem(); break;
                case 5: running = false; break;
                default: System.out.println("Invalid option. Try again."); break;
            }
        }
        System.out.println("Exiting... Thank you!");
        scanner.close();
    }

    private static void addItem() {
        System.out.print("Enter item name: ");
        String item = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int qty = scanner.nextInt();
        scanner.nextLine();  // consume newline

        inventory.put(item, inventory.getOrDefault(item, 0) + qty);
        System.out.println("Added " + qty + " of " + item);
    }

    private static void viewInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("Current inventory:");
            for (String item : inventory.keySet()) {
                System.out.println(item + " : " + inventory.get(item));
            }
        }
    }

    private static void updateItem() {
        System.out.print("Enter item name to update: ");
        String item = scanner.nextLine();
        if (inventory.containsKey(item)) {
            System.out.print("Enter new quantity: ");
            int qty = scanner.nextInt();
            scanner.nextLine();  // consume newline
            inventory.put(item, qty);
            System.out.println("Updated " + item + " to quantity " + qty);
        } else {
            System.out.println("Item not found.");
        }
    }

    private static void deleteItem() {
        System.out.print("Enter item name to delete: ");
        String item = scanner.nextLine();
        if (inventory.containsKey(item)) {
            inventory.remove(item);
            System.out.println("Deleted " + item);
        } else {
            System.out.println("Item not found.");
        }
    }
}
