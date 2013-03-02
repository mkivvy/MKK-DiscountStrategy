package mkk.discountstrategy;

/**
 *
 * 
 * @author Mary King, mking@my.wctc.edu
 * @version 1.0
 */
public class NoDiscount implements DiscountStrategy {

    @Override
    public final double getDiscount(double unitCost, int qty) {
        //no validation needed as parameters are not used
        return 0.0;
    }

    public static void main(String[] args) {
        NoDiscount noDisc = new NoDiscount();
        double myDisc = noDisc.getDiscount(25, 7);
        System.out.println(myDisc);
    }
}
