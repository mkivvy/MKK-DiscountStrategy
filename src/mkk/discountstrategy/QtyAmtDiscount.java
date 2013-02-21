package mkk.discountstrategy;

/**
 *
 * @author Mary
 */
public class QtyAmtDiscount implements DiscountStrategy {
    private double discountAmt = 1.00;
    private int minQty = 2;

    public QtyAmtDiscount(int minQty) {
        this.minQty = minQty;
    }

    @Override
    public double getDiscount (double unitCost, int qty) {
        if (qty >= minQty){
            return (qty/minQty) * discountAmt;
        } else {
            return 0.0;
        }
    }

    public double getDisccountAmt() {
        return discountAmt;
    }

    public void setDisccountAmt(double disccountAmt) {
        this.discountAmt = disccountAmt;
    }

    public int getMinQty() {
        return minQty;
    }

    public void setMinQty(int minQty) {
        this.minQty = minQty;
    }
    
    public static void main(String[] args) {
        QtyAmtDiscount qaDisc = new QtyAmtDiscount(3);
        double myDisc = qaDisc.getDiscount(10, 7);
        System.out.println(myDisc);
        
    }
}
