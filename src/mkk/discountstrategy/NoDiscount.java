package mkk.discountstrategy;

/**
 *
 * @author Mary
 */
public class NoDiscount implements DiscountStrategy {

    @Override
    public double getDiscount(double unitCost, int qty) {
        return 0.0;
    }

    public static void main(String[] args) {
        NoDiscount noDisc = new NoDiscount();
        double myDisc = noDisc.getDiscount(25, 7);
        System.out.println(myDisc);
    }
}
