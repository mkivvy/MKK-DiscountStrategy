package mkk.discountstrategy;

/**
 *
 * @author Mary
 */
public class CashRegister {

    private Receipt receipt;

    public CashRegister(String customerId, String productId, int qty) {
        if (productId == null) {
            throw new NullPointerException();
        } else if (productId.length() == 0){
            throw new IllegalArgumentException();
        }
        if (qty < 0){
            throw new IllegalArgumentException();
        }
        if (customerId == null) {
            throw new NullPointerException();
        } else if (customerId.length() == 0) {
            throw new IllegalArgumentException();
        }
        
        receipt = new Receipt(productId, qty, customerId);
    }
    
    public CashRegister(String productId, int qty) {
        if (productId == null) {
            throw new NullPointerException();
        } else if (productId.length() == 0){
            throw new IllegalArgumentException();
        }
        if (qty < 0){
            throw new IllegalArgumentException();
        }
        
        receipt = new Receipt(productId, qty);
    }
    
    public final void setCustomerId(String customerId){
        if (customerId == null) {
            throw new NullPointerException();
        } else if (customerId.length() == 0) {
            throw new IllegalArgumentException();
        }
        receipt.setCustomerId(customerId);
    }
    
    public final void addLineItem(String productId, int qty) {
        if (productId == null) {
            throw new NullPointerException();
        } else if (productId.length() == 0){
            throw new IllegalArgumentException();
        }
        if (qty < 0){
            throw new IllegalArgumentException();
        }
        receipt.addLineItem(productId, qty);
    }
    
    public final void finalizeSale() {
        receipt.produceReceipt();
    }
}
