package mkk.discountstrategy;

/**
 * NoDiscount uses the DiscountStrategy interface to create a class where no
 * discount is to be applied to the item.
 * It always returns a value of 0.0 for the discount calculation.
 * 
 * @author Mary King, mking@my.wctc.edu
 * @version 1.0
 */
public class NoDiscount implements DiscountStrategy {

    /**
     * The discount is always 0.0.
     * 
     * @param unitCost  the cost of one unit of the item is passed in as required
     *                  by the DiscountStrategy interface but is not used in 
     *                  this calculation
     * @param qty  the number of the item being purchased is passed in as required
     *             by the DiscountStrategy interface but is not used in this 
     *             calculation
     * @return  no discount, value of 0.0
     */
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
