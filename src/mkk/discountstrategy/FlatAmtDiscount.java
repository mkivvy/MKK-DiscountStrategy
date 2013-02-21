package mkk.discountstrategy;

/**
 *
 * @author Mary
 */
public class FlatAmtDiscount implements DiscountStrategy {

    private double discountAmt = 5.00;

    @Override
    public double getDiscount(double unitCost, int qty) {
        return discountAmt;
    }

    public double getDiscountAmt() {
        return discountAmt;
    }

    public void setDiscountAmt(double discountAmt) {
        this.discountAmt = discountAmt;
    }

    public static void main(String[] args) {
        FlatAmtDiscount flatAmtDisc = new FlatAmtDiscount();
        double myDisc = flatAmtDisc.getDiscount(25, 7);
        System.out.println(myDisc);

    }
}
