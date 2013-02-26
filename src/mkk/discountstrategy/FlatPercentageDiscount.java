package mkk.discountstrategy;

/**
 *
 * @author Mary
 */
public class FlatPercentageDiscount implements DiscountStrategy {

    private double discountPct = .10;

    @Override
    public final double getDiscount(double unitCost, int qty) {
        if (qty < 0 || unitCost < 0.0) {
            return 0.0;
        }
        return unitCost * qty * discountPct;
    }

    public final double getDiscountPct() {
        return discountPct;
    }

    public final void setDiscountPct(double discountPct) {
        if (discountPct < 0.0) {
            this.discountPct = 0.0;
        } else {
            this.discountPct = discountPct;
        }
    }

    public static void main(String[] args) {
        FlatPercentageDiscount flatPctDisc = new FlatPercentageDiscount();
        double myDisc = flatPctDisc.getDiscount(20.00, 5);
        System.out.println(myDisc);
    }
}
