/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mkk.discountstrategy;

/**
 *
 * @author Mary
 */
public class Startup {
    public static void main(String[] args) {
        CashRegister cashRegister = new CashRegister();
        cashRegister.setCustomerId("400");
        cashRegister.startSale("C3456", 3);
        cashRegister.addItemToSale("D4567", 2);
        cashRegister.addItemToSale("E5678", 1);
        cashRegister.finalizeSale();

        cashRegister.startSale("G7890", 1);
        cashRegister.addItemToSale("H8901", 1, true);
        cashRegister.setCustomerId("100");
        cashRegister.finalizeSale();

        cashRegister.startSale("I9012", 1);
        cashRegister.addItemToSale("G7890", 2);
        cashRegister.setCustomerId("300");
        cashRegister.addItemToSale("A1234", 1);
        cashRegister.addItemToSale("H8901", 6);
        cashRegister.finalizeSale();

        cashRegister.startSale("B2345", 4, true);
        cashRegister.setCustomerId("500");
        cashRegister.finalizeSale();
    }
}
