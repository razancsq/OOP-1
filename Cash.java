
package al.diwan.restaurant;


public class Cash implements Payment {
    private double cashTendered;
    @Override
    public boolean authorized() {
        return true;
    }
}
