package mkk.discountstrategy;

/**
 * FlatPercentageDiscount uses the DiscountStrategy interface to create a class
 * where a set percentage of the extended cost is the discount amount.
 * 
 * @author Mary King, mking@my.wctc.edu
 * @version 1.0
 */
public class FlatPercentageDiscount implements DiscountStrategy {

    private double discountPct = .10;
    
    /**
     * Default constructor merely instantiates the class without changing
     * the default value for the discount percent (.10).
     */
    public FlatPercentageDiscount() {
    }

    /**
     * Constructor instantiates the class setting the discount percent parameter.
     * 
     * @param discountPct  the discount percentage expressed as a double
     */
    public FlatPercentageDiscount(double discountPct) {
        setDiscountPct(discountPct);
    }

    /**
     * Calculate the flat percentage discount by multiplying the unit cost of
     * an item by the quantity purchased and the discount percent.  
     * If the unit cost or quantity parameter is zero, zero is returned.
     * 
     * @param unitCost  the cost of one unit of the item
     * @param qty  the number of the item being purchased
     * @return   the unit cost times the quantity times the discount percent -
     *           or zero if a value of zero is passed in for unitCost or qty
     */
    @Override
    public final double getDiscount(double unitCost, int qty) {
        if (qty < 0 || unitCost < 0.0) {
            return 0.0;
        }
        return unitCost * qty * discountPct;
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
     * @param discountPct  the discount percentage expressed as a double
     */
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
        FlatPercentageDiscount flatPctDisc2 = new FlatPercentageDiscount(.5);
        double myDisc2 = flatPctDisc2.getDiscount(20.00, 5);
        System.out.println(myDisc2);
    }
}
