

package al.diwan.restaurant;

import java.util.ArrayList;
import java.util.List;



public // Customer Class
class Customer extends Person {
    private String role;
    private List<Order> orders;

    public Customer(String name, String phone, String role) {
        super(name, phone);
        this.role = role;
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }
}
