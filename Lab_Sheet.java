import java.util.ArrayList;
import java.util.Scanner;

class Item {
    private String description;
    private String name;
    private double unitPrice;
    private int quantityAvailable;

    public Item(String name, String description, double unitPrice, int quantityAvailable) {
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.quantityAvailable = quantityAvailable;
    }

    public void updateQuantity(int amount) {
        // Rule: Quantity can't go below 0
        if (quantityAvailable + amount >= 0) {
            quantityAvailable += amount;
        } else {
            System.out.println("Error: Quantity cannot be negative. Current quantity: " + quantityAvailable);
        }
    }

    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Description: " + description);
        System.out.println("Unit Price: Rs " + unitPrice);
        System.out.println("Quantity Available: " + quantityAvailable);
        System.out.println("-------------------------");
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }
}

class Customer {
    private String name;
    private String contactDetails;

    public Customer(String name, String contactDetails) {
        this.name = name;
        this.contactDetails = contactDetails;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public void printDetails() {
        System.out.println("Name: " + name);
        System.out.println("Contact Details: " + contactDetails);
        System.out.println("-------------------------");
    }
}

class Database {
    private ArrayList<Item> items;
    private ArrayList<Customer> customers;

    public Database() {
        items = new ArrayList<>();
        customers = new ArrayList<>();
    }

    // Item methods
    public void addItem(Item item) {
        items.add(item);
    }

    public boolean removeItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                items.remove(item);
                return true;
            }
        }
        return false;
    }

    public Item searchItem(String name) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

    public boolean updateItemQuantity(String itemName, int amount) {
        Item item = searchItem(itemName);
        if (item != null) {
            item.updateQuantity(amount);
            return true;
        }
        return false;
    }

    public void listItems() {
        if (items.isEmpty()) {
            System.out.println("No items in inventory.");
        } else {
            for (Item item : items) {
                item.printDetails();
            }
        }
    }

    // Customer methods
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public boolean removeCustomer(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                customers.remove(customer);
                return true;
            }
        }
        return false;
    }

    public void listCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers in database.");
        } else {
            for (Customer customer : customers) {
                customer.printDetails();
            }
        }
    }

    public Customer searchCustomerByName(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null;
    }
}

public class InventoryManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Database database = new Database();

        while (true) {
            System.out.println("------ Inventory Management ------");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Update Item Quantity");
            System.out.println("4. List All Items");
            System.out.println("5. Add Customer");
            System.out.println("6. List All Customers");
            System.out.println("7. Search Item by Name");
            System.out.println("0. Exit");
            System.out.println("---------------------------------");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Add Item
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter item description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter unit price: ");
                    double unitPrice = scanner.nextDouble();
                    System.out.print("Enter quantity available: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Item newItem = new Item(name, description, unitPrice, quantity);
                    database.addItem(newItem);
                    System.out.println("Item added successfully!");
                    break;

                case 2: // Remove Item
                    System.out.print("Enter item name to remove: ");
                    String itemToRemove = scanner.nextLine();
                    if (database.removeItem(itemToRemove)) {
                        System.out.println("Item removed successfully!");
                    } else {
                        System.out.println("Item not found!");
                    }
                    break;

                case 3: // Update Item Quantity
                    System.out.print("Enter item name: ");
                    String itemToUpdate = scanner.nextLine();
                    System.out.print("Enter quantity change (positive to add, negative to subtract): ");
                    int quantityChange = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    if (database.updateItemQuantity(itemToUpdate, quantityChange)) {
                        System.out.println("Quantity updated successfully!");
                    } else {
                        System.out.println("Item not found!");
                    }
                    break;

                case 4: // List All Items
                    System.out.println("\n--- All Items ---");
                    database.listItems();
                    break;

                case 5: // Add Customer
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter contact details: ");
                    String contactDetails = scanner.nextLine();

                    Customer newCustomer = new Customer(customerName, contactDetails);
                    database.addCustomer(newCustomer);
                    System.out.println("Customer added successfully!");
                    break;

                case 6: // List All Customers
                    System.out.println("\n--- All Customers ---");
                    database.listCustomers();
                    break;

                case 7: // Search Item by Name
                    System.out.print("Enter item name to search: ");
                    String itemToSearch = scanner.nextLine();
                    Item foundItem = database.searchItem(itemToSearch);
                    if (foundItem != null) {
                        System.out.println("\n--- Item Found ---");
                        foundItem.printDetails();
                    } else {
                        System.out.println("Item not found!");
                    }
                    break;

                case 0: // Exit
                    System.out.println("Exiting program...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();  //Next Line
        }
    }
}

