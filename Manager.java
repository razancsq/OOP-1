

package al.diwan.restaurant;

import java.util.ArrayList;
import java.util.List;


public // Manager Class
class Manager extends Person {
    private final String password;
    private final List<String[]> meals = new ArrayList<>();

    public Manager(String name, String phone, String password) {
        super(name, phone);
        this.password = password;
    }

    public boolean verifyPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    public void addMeal(String mealName, double price) {
        meals.add(new String[]{mealName, String.valueOf(price)});
    }

    public boolean deleteMeal(String mealName) {
        for (String[] meal : meals) {
            if (meal[0].equalsIgnoreCase(mealName)) {
                meals.remove(meal);
                return true;
            }
        }
        return false;
    }

    public void viewMenu() {
        if (meals.isEmpty()) System.out.println("The menu is empty.");
        else {
            for (String[] meal : meals) {
                System.out.println(meal[0] + ": " + meal[1] + " SAR");
            }
        }
    }
    public boolean isMenuEmpty() {
        return meals.isEmpty();
    }

    public Double getMealPrice(String mealName) {
        for (String[] meal : meals) {
            if (meal[0].equalsIgnoreCase(mealName)) return Double.parseDouble(meal[1]);
        }
        return null;
    }
}