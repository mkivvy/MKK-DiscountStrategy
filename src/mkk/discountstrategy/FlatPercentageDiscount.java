package mkk.discountstrategy;

/**
 *
 * @author Mary
 */
public class FlatPercentageDiscount implements DiscountStrategy {

    private double discountPct = .10;

    @Override
    public double getDiscount(double unitCost, int qty) {
        return unitCost * qty * discountPct;
    }

    public double getDiscountPct() {
        return discountPct;
    }

    public void setDiscountPct(double discountPct) {
        this.discountPct = discountPct;
    }

    public static void main(String[] args) {
        FlatPercentageDiscount flatPctDisc = new FlatPercentageDiscount();
        double myDisc = flatPctDisc.getDiscount(20, 5);
        System.out.println(myDisc);
    }
}
