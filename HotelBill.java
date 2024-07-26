import java.util.ArrayList;
import java.util.List;

class HotelBilldemo {
    private List<BillItem> items;

    HotelBilldemo() {
        this.items = new ArrayList<>();
    }

    public void addItem(String itemName, double price, int quantity) {
        items.add(new BillItem(itemName, price, quantity));
    }

    public double calculateTotal() {
        double total = 0.0;
        for (BillItem item : items) {
            total += item.getTotalCost();
        }
        return total;
    }

    public void printBill() {
        System.out.println("********************************************");
        System.out.println("                HOTEL BILL");
        System.out.println("********************************************");
        System.out.printf("%-20s %-10s %-10s %-10s\n", "Item", "Price", "Quantity", "Total");
        System.out.println("********************************************");

        for (BillItem item : items) {
            System.out.printf("%-20s $%-9.2f %-10d $%-9.2f\n",
                    item.getItemName(), item.getPrice(), item.getQuantity(), item.getTotalCost());
        }

        System.out.println("********************************************");
        System.out.printf("%-40s $%-9.2f\n", "Total:", calculateTotal());
        System.out.println("********************************************");
    }

    private static class BillItem {
        private String itemName;
        private double price;
        private int quantity;

        public BillItem(String itemName, double price, int quantity) {
            this.itemName = itemName;
            this.price = price;
            this.quantity = quantity;
        }

        public String getItemName() {
            return itemName;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }

        public double getTotalCost() {
            return price * quantity;
        }
    }
}

public class HotelBill {
    public static void main(String[] args) {
        HotelBill hotelBill = new HotelBill();

        // Adding items to the bill
        HotelBilldemo.addItem("Room Charge", 150.00, 1);
        HotelBilldemo.addItem("Dinner", 30.00, 2);
        HotelBilldemo.addItem("Laundry", 10.00, 3);

        // Printing the extraordinary output
        HotelBilldemo.printBill();
    }
}
