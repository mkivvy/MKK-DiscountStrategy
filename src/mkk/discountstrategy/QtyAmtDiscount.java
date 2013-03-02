package mkk.discountstrategy;

/**
 *
 * 
 * @author Mary King, mking@my.wctc.edu
 * @version 1.0
 */
public class QtyAmtDiscount implements DiscountStrategy {
    private double discountAmt = 1.00;
    private int minQty = 2;

    public QtyAmtDiscount(double discountAmt, int minQty) {
        setDiscountAmt(discountAmt);
        setMinQty(minQty);
    }

    public QtyAmtDiscount(int minQty) {
        setMinQty(minQty);
    }

    @Override
    public final double getDiscount (double unitCost, int qty) {
        if (qty < 0 || unitCost < 0.0) {
            return 0.0;
        }
        if (qty >= minQty){
            return (qty/minQty) * discountAmt;
        } else {
            return 0.0;
        }
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

    public final int getMinQty() {
        return minQty;
    }

    public final void setMinQty(int minQty) {
        if (minQty < 1) {
            this.minQty = 1;
        } else {
            this.minQty = minQty;
        }
    }
    
    public static void main(String[] args) {
        QtyAmtDiscount qaDisc = new QtyAmtDiscount(3);
        double myDisc = qaDisc.getDiscount(10.0, 7);
        System.out.println(myDisc);
        QtyAmtDiscount qaDisc2 = new QtyAmtDiscount(.5, 3);
        double myDisc2 = qaDisc2.getDiscount(10.0, 7);
        System.out.println(myDisc2);
        
    }
}
