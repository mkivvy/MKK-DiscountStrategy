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

    public abstract double getDiscount(double unitCost, int qty);
    
}
