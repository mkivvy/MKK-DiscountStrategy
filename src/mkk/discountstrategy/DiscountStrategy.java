package mkk.discountstrategy;

/**
 * DiscountStrategy is the interface specifying what is needed for setting up 
 * discount classes within the MKK-DiscountStrategy Project.
 * Every class implementing DiscountStrategy must have a method called getDiscount
 * which accepts a unit cost and a quantity and returns the calculated discount.
 * 
 * @author Mary King, mking@my.wctc.edu
 * @version 1.0
 */
public interface DiscountStrategy {

    /**
     * Calculates the discount amount for the quantity of the product being 
     * purchased using the product's unit cost and discount strategy
     * 
     * @param unitCost  the cost of one unit of the item being purchased
     * @param qty  the number of the item being purchased
     */
    public abstract double getDiscount(double unitCost, int qty);
    
}
