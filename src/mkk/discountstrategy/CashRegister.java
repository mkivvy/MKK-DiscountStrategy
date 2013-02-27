package mkk.discountstrategy;

/**
 *
 * @author Mary
 */
public class CashRegister {

    private Receipt receipt;
    private String customerId;

    public CashRegister() {
    }

    public CashRegister(String customerId, String productId, int qty, 
            boolean issueGiftReceipt) {
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
    
    public final void startSale(String productId, int qty){
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
    
    public final void startSale(String productId, int qty, boolean issueGiftReceipt){
        if (productId == null) {
            throw new NullPointerException();
        } else if (productId.length() == 0){
            throw new IllegalArgumentException();
        }
        if (qty < 0){
            throw new IllegalArgumentException();
        }
        
        receipt = new Receipt(productId, qty, issueGiftReceipt);
    }
    
    public final void setCustomerId(String customerId){
        if (customerId == null) {
            throw new NullPointerException();
        } else if (customerId.length() == 0) {
            throw new IllegalArgumentException();
        }
        //The following code allows for the customer id to be entered at
        //any time during the sale
        if (receipt != null){
            receipt.setCustomerId(customerId);
            this.customerId = customerId;
        } else {
            this.customerId = customerId;
        }
        
    }
    
    public final void addItemToSale(String productId, int qty) {
        if (productId == null) {
            throw new NullPointerException();
        } else if (productId.length() == 0){
            throw new IllegalArgumentException();
        }
        if (qty < 0){
            throw new IllegalArgumentException();
        }
        receipt.addLineItem(productId, qty, false);
    }
    
    public final void addItemToSale(String productId, int qty, 
            boolean issueGiftReceipt) {
        if (productId == null) {
            throw new NullPointerException();
        } else if (productId.length() == 0){
            throw new IllegalArgumentException();
        }
        if (qty < 0){
            throw new IllegalArgumentException();
        }
        receipt.addLineItem(productId, qty, issueGiftReceipt);
    }
    
    public final void finalizeSale() {
        //Check to see if a customer id was entered, but not yet applied
        //to the receipt (customer id was entered at beginning or middle of
        //sale instead of at end)
        if ((this.customerId != null) && (receipt.getCustomerId() == null)) {
            receipt.setCustomerId(this.customerId);
        }
        receipt.produceReceipt();
        //set receipt for garbage collector as we are finished with this one -
        //at the start of the next sale, a new receipt is created
        receipt = null; 
    }
}
