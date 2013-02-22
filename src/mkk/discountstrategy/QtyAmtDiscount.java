package mkk.discountstrategy;

/**
 *
 * @author Mary
 */
public class QtyAmtDiscount implements DiscountStrategy {
    private double discountAmt = 1.00;
    private int minQty = 2;

    public QtyAmtDiscount(int minQty) {
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
            return (qty/minQty) * discountAmt;
        } else {
            return 0.0;
        }
    }

    public double getDiscountAmt() {
        return discountAmt;
    }

    public void setDiscountAmt(double discountAmt) {
        if (discountAmt < 0.0) {
            this.discountAmt = 0.0;
        } else {
            this.discountAmt = discountAmt;
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
        QtyAmtDiscount qaDisc = new QtyAmtDiscount(3);
        double myDisc = qaDisc.getDiscount(10, 7);
        System.out.println(myDisc);
        
    }
}
