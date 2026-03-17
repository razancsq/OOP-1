

package al.diwan.restaurant;
// Abstract Order Class
public abstract class Order {
    protected double totalCost;
    protected String currency = "SAR";

    public Order(double totalCost) {
        this.totalCost = totalCost;
    }

    public abstract double calculateTotal();

    @Override
    public String toString() {
        return "Total: " + calculateTotal() + " " + currency;
    }
}

class OnSite extends Order {
    private String branch;

    public OnSite(double totalCost, String branch) {
        super(totalCost);
        this.branch = branch;
    }

    public double calculateTotal() {
        return totalCost;
    }

    @Override
    public String toString() {
        return super.toString() + ", Branch: " + branch;
    }
}

class Takeaway extends Order {
    private static final double deliveryFees = 15;

    public Takeaway(double totalCost) {
        super(totalCost);
    }

    public double calculateTotal() {
        return totalCost + deliveryFees;
    }

    @Override
    public String toString() {
        return super.toString() + ", Delivery Fees: " + deliveryFees;
    }
}