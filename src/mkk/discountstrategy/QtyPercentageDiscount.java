package mkk.discountstrategy;

/**
 *
 * @author Mary
 */
public class QtyPercentageDiscount implements DiscountStrategy {
    private double discountPct = .10;
    private int minQty = 3;

    public QtyPercentageDiscount(int minQty) {
        this.minQty = minQty;
    }
    
    @Override
    public double getDiscount (double unitCost, int qty) {
        if (qty >= minQty){
            return unitCost * qty * discountPct;
        } else {
            return 0.0;
        }
    }

    public double getDiscountPct() {
        return discountPct;
    }

    public void setDiscountPct(double discountPct) {
        this.discountPct = discountPct;
    }

    public int getMinQty() {
        return minQty;
    }

    public void setMinQty(int minQty) {
        this.minQty = minQty;
    }
    
    public static void main(String[] args) {
        QtyPercentageDiscount qpDisc = new QtyPercentageDiscount(2);
        double myDisc = qpDisc.getDiscount(10.00, 1);
        System.out.println(myDisc);
    }
}