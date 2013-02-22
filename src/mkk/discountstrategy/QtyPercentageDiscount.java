package mkk.discountstrategy;

/**
 *
 * @author Mary
 */
public class QtyPercentageDiscount implements DiscountStrategy {
    private double discountPct = .10;
    private int minQty = 3;

    public QtyPercentageDiscount(int minQty) {
        if (minQty < 1) {
            this.minQty = 1;
        } else {
            this.minQty = minQty;
        }
    }
    
    @Override
    public double getDiscount (double unitCost, int qty) {
        if (qty < 0 || unitCost < 0.0) {
            return 0.0;
        }
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
        if (discountPct < 0.0) {
            this.discountPct = 0.0;
        } else {
            this.discountPct = discountPct;
        }
    }

    public int getMinQty() {
        return minQty;
    }

    public void setMinQty(int minQty) {
        if (minQty < 1) {
            this.minQty = 1;
        } else {
            this.minQty = minQty;
        }
    }
    
    public static void main(String[] args) {
        QtyPercentageDiscount qpDisc = new QtyPercentageDiscount(2);
        double myDisc = qpDisc.getDiscount(10.00, 1);
        System.out.println(myDisc);
    }
}
