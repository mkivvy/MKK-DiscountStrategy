package mkk.discountstrategy;

/**
 * QtyAmtDiscount uses the DiscountStrategy interface to create a class where
 * for every set of a minimum quantity of items purchased a set discount
 * amount value is applied.
 * 
 * @author Mary King, mking@my.wctc.edu
 * @version 1.0
 */
public class QtyAmtDiscount implements DiscountStrategy {
    private double discountAmt = 1.00;
    private int minQty = 2;

    /**
     * Constructor instantiates the class setting the minimum quantity parameter. 
     * 
     * @param minQty  the minimum number of the item to be purchased before the
     *                discount will be applied
     */
    public QtyAmtDiscount(int minQty) {
        setMinQty(minQty);
    }

    /**
     * Constructor instantiates the class setting the discount amount value and 
     * the minimum quantity parameter. 
     * 
     * @param discountAmt  the dollar and cents amount to be applied for every
     *                     set of the minimum quantity of items
     * @param minQty  the minimum number of the item to be purchased before the
     *                discount will be applied
     */
    public QtyAmtDiscount(double discountAmt, int minQty) {
        setDiscountAmt(discountAmt);
        setMinQty(minQty);
    }

    /**
     * Calculate the quantity amount discount by multiplying the unit cost of
     * an item by the quantity purchased and the discount percent.  
     * If the unit cost or quantity parameter is zero, zero is returned.
     * 
     * @param unitCost  the cost of one unit of the item is passed in as required
     *                  by the DiscountStrategy interface but is not used in 
     *                  this calculation.  Defaults to zero if a lesser value
     *                  is passed in
     * @param qty  the number of the item being purchased
     * @return  each set of the of the minimum quantity multiplied by the value
     *          of the discount amount (for example, if the minimum quantity
     *          is 2, the quantity purchased is 5, and the discount amount is
     *          3: (5/2) * 3.00 = 6.00)
     */
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

    /**
     * Returns the value of the private variable for discount amount.
     * 
     * @return  the discount amount expressed as a double for dollars and cents
     */
    public final double getDiscountAmt() {
        return discountAmt;
    }

    /**
     * Sets the value of the private variable for discount amount.
     * 
     * @param discountAmt  the discount amount expressed as a double for dollars 
     *                     and cents.  Defaults to zero if a lesser value is
     *                     passed in
     */
    public final void setDiscountAmt(double discountAmt) {
        if (discountAmt < 0.0) {
            this.discountAmt = 0.0;
        } else {
            this.discountAmt = discountAmt;
        }
    }

    /**
     * Returns the value of the private variable for minimum quantity.
     * 
     * @return   the value of minimum number of the item to be purchased before
     *           the discount will be applied
     */
    public final int getMinQty() {
        return minQty;
    }

    /**
     * Sets the value of the private variable for minimum quantity.  
     * If the value passed in is less than 1, it is set to 1.
     * 
     * @param minQty  the minimum number of the item to be purchased before the
     *                discount will be applied.  Defaults to 1 if a lesser
     *                value is passed in
     */
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
