package mkk.discountstrategy;

/**
 * FlatAmtDiscount uses the DiscountStrategy interface to create a class where
 * a flat discount amount value is applied, not dependant on the item's unit 
 * cost or the quantity purchased.
 * 
 * @author Mary King, mking@my.wctc.edu
 * @version 1.0
 */
public class FlatAmtDiscount implements DiscountStrategy {

    private double discountAmt = 2.00;

    /**
     * Constructor merely instantiates the class using the default value of 2.00
     * for the discount amount parameter. 
     */
    public FlatAmtDiscount() {
    }

    /**
     * Constructor instantiates the class setting the discount amount parameter. 
     * 
     * @param discountAmt  the discount amount expressed as a double for dollars 
     *                     and cents.  Defaults to zero if a lesser value is
     *                     passed in
     */
    public FlatAmtDiscount(double discountAmt) {
        setDiscountAmt(discountAmt);
    }

    /**
     * The discount amount is a set amount that is discount amount no matter
     * what the item's unit cost is or the quantity being purchased.
     * 
     * @param unitCost  the cost of one unit of the item is passed in as required
     *                  by the DiscountStrategy interface but is not used in 
     *                  this calculation
     * @param qty  the number of the item being purchased is passed in as required
     *             by the DiscountStrategy interface but is not used in this 
     *             calculation
     * @return  the discount amount expressed as a double for dollars and cents
     */
    @Override
    public final double getDiscount(double unitCost, int qty) {
        //no validation needed as parameters are not needed
        return discountAmt;
    }

    /**
     * Returns the value of the private variable for discount amount.
     * 
     * @return  the discount amount expressed as a double for dollars and cents
     */
    public final double getDiscountAmt() {
        return discountAmt;
    }

    /**
     * Sets the value of the private variable for discount amount.
     * 
     * @param discountAmt  the discount amount expressed as a double for dollars 
     *                     and cents.  Defaults to zero if a lesser value is
     *                     passed in
     */
    public final void setDiscountAmt(double discountAmt) {
        if (discountAmt < 0.0) {
            this.discountAmt = 0.0;
        } else {
            this.discountAmt = discountAmt;
        }
    }

    public static void main(String[] args) {
        FlatAmtDiscount flatAmtDisc = new FlatAmtDiscount();
        double myDisc = flatAmtDisc.getDiscount(25, 7);
        System.out.println(myDisc);
        FlatAmtDiscount flatAmtDisc2 = new FlatAmtDiscount(5.0);
        double myDisc2 = flatAmtDisc2.getDiscount(25, 7);
        System.out.println(myDisc2);

    }
}
