package mkk.discountstrategy;

/**
 * QtyPercentageDiscount uses the DiscountStrategy interface to create a class
 * where a minimum quantity of items purchased results in calculating a discount
 * using a set percentage of the extended cost for the discount amount.
 * 
 * @author Mary King, mking@my.wctc.edu
 * @version 1.0
 */
public class QtyPercentageDiscount implements DiscountStrategy {
    private double discountPct = .10;
    private int minQty = 3;

    /**
     * Constructor instantiates the class setting the minimum quantity parameter. 
     * 
     * @param minQty  the minimum number of the item to be purchased before the
     *                discount will be applied
     */
    public QtyPercentageDiscount(int minQty) {
        setMinQty(minQty);
    }
    
    /**
     * Constructor instantiates the class setting the minimum quantity and the 
     * discount percent parameters.
     * 
     * @param minQty  the minimum number of the item to be purchased before the
     *                discount will be applied
     * @param discountPct  the discount percentage expressed as a double
     */
    public QtyPercentageDiscount(int minQty, double discountPct) {
        setDiscountPct(discountPct);
        setMinQty(minQty);
    }
    /**
     * Calculate the quantity percentage discount by first checking to see if 
     * the minimum number of items (or more) is being purchased.  
     * If so, multiply the unit cost of an item by the quantity purchased and 
     * the discount percent.  
     * If not, there is no discount to be applied, so zero is returned. 
     * If the unit cost or quantity parameter is zero, zero is returned.
     * 
     * @param unitCost  the cost of one unit of the item
     * @param qty  the number of the item being purchased
     * @return   the unit cost times the quantity times the discount percent -
     *           or zero if a value of zero is passed in for unitCost or qty
     */
    @Override
    public final double getDiscount (double unitCost, int qty) {
        if (qty < 0 || unitCost < 0.0) {
            return 0.0;
        }
        if (qty >= minQty){
            return unitCost * qty * discountPct;
        } else {
            return 0.0;
        }
    }

    /**
     * Returns the value of the private variable for discount percent.
     * 
     * @return  the discount percentage expressed as a double
     */
    public final double getDiscountPct() {
        return discountPct;
    }

    /**
     * Sets the value of the private variable for discount percent.
     * 
     * @param discountPct  the discount percentage expressed as a double or 
     *                     zero if a value less than zero is passed in 
     */
    public final void setDiscountPct(double discountPct) {
        if (discountPct < 0.0) {
            this.discountPct = 0.0;
        } else {
            this.discountPct = discountPct;
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
     * 
     * @param minQty  the minimum number of the item to be purchased before the
     *                discount will be applied.  Defaults to 1 if a value less
     *                than 1 is passed in
     */
    public final void setMinQty(int minQty) {
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
        QtyPercentageDiscount qpDisc2 = new QtyPercentageDiscount(2, .5);
        double myDisc2 = qpDisc2.getDiscount(10.00, 5);
        System.out.println(myDisc2);
    }
}
