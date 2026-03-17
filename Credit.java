





package al.diwan.restaurant;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Credit implements Payment {
    private String nameOnCard, expDate;
    private int cardNumber;

    public Credit(String nameOnCard, String expDate, int cardNumber) {
        this.nameOnCard = nameOnCard;
        this.expDate = expDate;
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean authorized() {
        try {
            Date exp = new SimpleDateFormat("dd-MM-yyyy").parse(expDate);//user must use this formate of date 
            return exp.after(new Date());
        } catch (Exception e) {
            System.out.println("Invalid date format.");
            return false;
        }
    }
}
