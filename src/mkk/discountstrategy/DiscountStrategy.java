/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mkk.discountstrategy;

/**
 *
 * @author Mary
 */
public interface DiscountStrategy {

    double getDiscount(double unitCost, int qty);
    
}
