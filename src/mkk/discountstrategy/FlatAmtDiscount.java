package mkk.discountstrategy;

/**
 *
 * 
 * @author Mary King, mking@my.wctc.edu
 * @version 1.0
 */
public class FlatAmtDiscount implements DiscountStrategy {

    private double discountAmt = 2.00;

    public FlatAmtDiscount() {
    }

    public FlatAmtDiscount(double discountAmt) {
        setDiscountAmt(discountAmt);
    }

    @Override
    public final double getDiscount(double unitCost, int qty) {
        //no validation needed as parameters are not needed
        return discountAmt;
    }

    public final double getDiscountAmt() {
        return discountAmt;
    }

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
