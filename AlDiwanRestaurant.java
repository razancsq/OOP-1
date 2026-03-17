package al.diwan.restaurant;

import java.text.SimpleDateFormat;
import java.util.*;

// Main Class
public class AlDiwanRestaurant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Manager manager = new Manager("Manager", "000000", "mng22");

        System.out.println("Welcome to Al Diwan Restaurant");
        while (true) {
            System.out.println("\n1. Manager\n2. Customer\n3. Exit");
            System.out.print("Are you a Manager or Customer? ");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                System.out.print("Enter Manager Password: ");
                String password = scanner.nextLine();
                if (!manager.verifyPassword(password)) {
                    System.out.println("Incorrect password, Access denied");
                    continue;
                }
                while (true) {
                    System.out.println("\nManager Options:\n1. Add Meal\n2. Delete Meal\n3. View Menu\n4. Back");
                    System.out.print("Choose an option: ");
                    String mChoice = scanner.nextLine();
                    if (mChoice.equals("1")) {
                        System.out.print("Enter Meal Name: ");
                        String mealName = scanner.nextLine();
                        System.out.print("Enter Price: ");
                        double price = Double.parseDouble(scanner.nextLine());
                        manager.addMeal(mealName, price);
                        System.out.println("Meal added.");
                    } else if (mChoice.equals("2")) {
                        System.out.print("Enter Meal Name: ");
                        String mealName = scanner.nextLine();
                        if (manager.deleteMeal(mealName)) System.out.println("Meal deleted.");
                        else System.out.println("Meal not found.");
                    } else if (mChoice.equals("3")) manager.viewMenu();
                    else if (mChoice.equals("4")) break;
                    else System.out.println("Invalid choice.");
                }
            } else if (choice.equals("2")) {
                if (manager.isMenuEmpty()) {
                    System.out.println("The menu is empty. Please wait until the manager adds meals.");
                    continue;
                }
                double totalCost = 0;
                System.out.println("\nMenu:");
                manager.viewMenu();
                while (true) {
                    System.out.print("Enter Meal Name to Order (or 'done'): ");
                    String mealName = scanner.nextLine();
                    if (mealName.equalsIgnoreCase("done")) break;
                    Double price = manager.getMealPrice(mealName);
                    if (price != null) {
                        totalCost += price;
                        System.out.println(mealName + " added. Price: " + price);
                    } else if (!mealName.equalsIgnoreCase("done")) {
                        System.out.println("Meal not found.");
                    }
                }
                if (totalCost == 0) {
                    System.out.println("You have not ordered any meals. Returning to the main menu.");
                    continue;
                }
                System.out.print("Enter your full name: ");
                String name = scanner.nextLine();
                System.out.print("Enter your phone number: ");
                String phone = scanner.nextLine();
                Customer customer = new Customer(name, phone, "Customer");

                System.out.print("Is this order Takeaway or OnSite? (T/O): ");
                String type = scanner.nextLine();
                while (!(type.equalsIgnoreCase("T") || type.equalsIgnoreCase("O"))) {
                    System.out.println("Invalid choice, type T or O only");
                    type = scanner.nextLine();
                }
                Order order;
                if (type.equalsIgnoreCase("T")) {
                    order = new Takeaway(totalCost);
                } else order = new OnSite(totalCost, "Main Branch");

                customer.addOrder(order);
                System.out.println("Your Order Details:\n" + order);

                System.out.print("Payment Method (Card/Cash): ");
                String paymentMethod = scanner.nextLine();

                if (paymentMethod.equalsIgnoreCase("Card")) {
                    System.out.print("Card Holder Name: ");
                    String cardName = scanner.nextLine();
                    System.out.print("Card Expiry Date (dd-MM-yyyy): ");
                    String expDate = scanner.nextLine();
                    System.out.print("Card Number: ");
                    int cardNumber;
                    while (true) {
                        String cardNumberInput = scanner.nextLine();
                        try {
                            cardNumber = Integer.parseInt(cardNumberInput);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid card number.");
                        }
                    }
                    Credit payment = new Credit(cardName, expDate, cardNumber);
                    if (payment.authorized()) System.out.println("Payment successful! Thank you.");
                    else System.out.println("Payment failed. Card expired.");
                } else if (paymentMethod.equalsIgnoreCase("Cash")) {
                    Cash payment = new Cash();
                    if (payment.authorized()) System.out.println("Payment successful! Thank you.");
                } else {
                    System.out.println("Invalid payment method. Returning to the main menu.");
                }
            } else if (choice.equals("3")) {
                System.out.println("Thanks for choosing Al Diwan Restaurant. We hope you enjoyed your meal!");
                break;
            } else System.out.println("Invalid choice, please enter 1 or 2 or 3");
        }
        scanner.close();
    }
}














