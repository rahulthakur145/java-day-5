package casestudy7classassinement;

import java.util.*;

abstract class Item {
    String itemID;
    String name;
    double basePrice;

    Item(String itemID, String name, double basePrice) {
        this.itemID = itemID;
        this.name = name;
        this.basePrice = basePrice;
    }

    abstract double calculateTax();

    double getTotalPrice() {
        return basePrice + calculateTax();
    }

    public String toString() {
        return itemID + " | " + name + " | $" + basePrice;
    }
}

interface Taxable {
    double calculateTax();
}

class PerishableItem extends Item implements Taxable {
    String expiryDate;

    PerishableItem(String itemID, String name, double basePrice, String expiryDate) {
        super(itemID, name, basePrice);
        this.expiryDate = expiryDate;
    }

    public double calculateTax() {
        return basePrice * 0.05;
    }

    public String toString() {
        return super.toString() + " | Expiry: " + expiryDate;
    }
}

class ElectronicItem extends Item implements Taxable {
    int warrantyPeriod;

    ElectronicItem(String itemID, String name, double basePrice, int warrantyPeriod) {
        super(itemID, name, basePrice);
        this.warrantyPeriod = warrantyPeriod;
    }

    public double calculateTax() {
        return basePrice * 0.15;
    }

    public String toString() {
        return super.toString() + " | Warranty: " + warrantyPeriod + " months";
    }
}

public class LogistiTechSmartWarehouse {

    static int lastNumber = 0;
    static String prefix = "";

    static String generateNextID() {
        lastNumber++;
        return prefix + lastNumber;
    }

    static void initializeID(String firstID) {
        prefix = firstID.replaceAll("\\d", "");
        String numberPart = firstID.replaceAll("\\D", "");
        lastNumber = Integer.parseInt(numberPart);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<String, Item> inventory = new HashMap<>();
        ArrayList<Item> itemList = new ArrayList<>();

        boolean firstIDSet = false;

        while (true) {
            System.out.println("1.Add Perishable 2.Add Electronic 3.Display 4.Search 5.Total Value 6.Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1 || choice == 2) {

                String id;

                if (!firstIDSet) {
                    System.out.print("Enter First ID: ");
                    id = sc.nextLine();
                    initializeID(id);
                    firstIDSet = true;
                } else {
                    id = generateNextID();
                    System.out.println("Auto Generated ID: " + id);
                }

                System.out.print("Name: ");
                String name = sc.nextLine();

                System.out.print("Price: ");
                double price = sc.nextDouble();
                sc.nextLine();

                Item item;

                if (choice == 1) {
                    System.out.print("Expiry Date: ");
                    String expiry = sc.nextLine();
                    item = new PerishableItem(id, name, price, expiry);
                } else {
                    System.out.print("Warranty (months): ");
                    int warranty = sc.nextInt();
                    sc.nextLine();
                    item = new ElectronicItem(id, name, price, warranty);
                }

                inventory.put(id, item);
                itemList.add(item);

            } else if (choice == 3) {
                itemList.sort(Comparator.comparingDouble(i -> i.basePrice));
                for (Item item : itemList) {
                    System.out.println(item);
                }

            } else if (choice == 4) {
                System.out.print("Enter ID: ");
                String id = sc.nextLine();
                if (inventory.containsKey(id)) {
                    System.out.println(inventory.get(id));
                } else {
                    System.out.println("Item not found");
                }

            } else if (choice == 5) {
                double total = 0;
                for (Item item : itemList) {
                    total += item.getTotalPrice();
                }
                System.out.printf("Total Inventory Value (Incl. Tax): $%.2f\n", total);

            } else if (choice == 6) {
                break;
            }
        }
        sc.close();
    }
}