package mkk.discountstrategy;

/**
 * CashRegister is a concrete class used to control sales processing in the 
 * MKK-DiscountStrategy Project.
 * It instantiates a Receipt object for each sale which handles product information
 * gathering, calculating totals, and printing a receipt.
 * <p>
 * Customer id is also a private field in this class to enable the customer's
 * card to be swiped at any point during the sale, not just at the beginning or
 * the end.
 * 
 * @author Mary King, mking@my.wctc.edu
 * @version 1.0
 */
public class CashRegister {

    private Receipt receipt;
    private String customerId;

    /**
     * Default constructor instantiates the class using no parameters.  
     * Useful when simply starting up the register without starting a sale.
     * All information needed can be passed into this class when a sale is
     * actually started.
     */
    public CashRegister() {
    }

    /**
     * Constructor instantiates the class using the customer id, the product id, 
     * the quantity of the product being purchased, indication to issue a gift
     * receipt, and the discount strategy to be used when calculating totals for
     * the product being purchased.
     * 
     * @param customerId  the customer id, a unique string identifying the 
     *                    customer, not null, not empty
     * @param productId  the product id, a unique string identifying the product.
     *                   not null, not empty
     * @param qty  the number of the item being purchased
     * @param issueGiftReceipt  true if a gift receipt is to be issued for the
     *                          product
     * @param discStrategy  the discount strategy type of class being used to 
     *                      calculate the discount for this particular product.
     * @throws  NullPointerException if the productId, the customerId, or
     *          discStrategy parameter is null
     * @throws  IllegalArgumentException if the productId or the customerId
     *          parameter is empty, the qty parameter is less than zero, or
     *          discStrategy parameter is not a Discount Strategy object type
     */
    public CashRegister(String customerId, String productId, int qty, 
            boolean issueGiftReceipt, DiscountStrategy discStrategy) {
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
        if (discStrategy == null) {
            throw new NullPointerException();
        } else if (!(discStrategy instanceof DiscountStrategy)) {
            throw new IllegalArgumentException();
        }        
        receipt = new Receipt(productId, qty, customerId, issueGiftReceipt, 
                discStrategy);
    }
    
    /**
     * Constructor instantiates the class using the the product id, and the
     * quantity of the product being purchased.  
     * Using this constructor, the customer id can be added later at any point 
     * in the sale.  
     * The product's discount will be calculated using the product's own 
     * assigned discount strategy stored in the product database.
     * Gift receipts will not be issued.
     * 
     * @param productId  the product id, a unique string identifying the product.
     *                   not null, not empty
     * @param qty  the number of the item being purchased
     * @throws  NullPointerException if the productId parameter is null
     * @throws  IllegalArgumentException if the productId parameter is empty
     *          or the qty parameter is less than zero
     */
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
    
    public final void startSale(String productId, int qty, String custId){
        if (productId == null) {
            throw new NullPointerException();
        } else if (productId.length() == 0){
            throw new IllegalArgumentException();
        }
        if (qty < 0){
            throw new IllegalArgumentException();
        }
        if (custId == null) {
            throw new NullPointerException();
        } else if (custId.length() == 0){
            throw new IllegalArgumentException();
        }
        
        receipt = new Receipt(productId, qty, custId);
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
    
    public final void startSale(String productId, int qty,
            boolean issueGiftReceipt, DiscountStrategy discStrategy){
        if (productId == null) {
            throw new NullPointerException();
        } else if (productId.length() == 0){
            throw new IllegalArgumentException();
        }
        if (qty < 0){
            throw new IllegalArgumentException();
        }
        if (discStrategy == null) {
            throw new NullPointerException();
        } else if (!(discStrategy instanceof DiscountStrategy)) {
            throw new IllegalArgumentException();
        }        
        receipt = new Receipt(productId, qty, issueGiftReceipt, discStrategy);
    }
    
    public final void startSale(String productId, int qty, String custId, 
            boolean issueGiftReceipt, DiscountStrategy discStrategy){
        if (productId == null) {
            throw new NullPointerException();
        } else if (productId.length() == 0){
            throw new IllegalArgumentException();
        }
        if (qty < 0){
            throw new IllegalArgumentException();
        }
        if (custId == null) {
            throw new NullPointerException();
        } else if (custId.length() == 0){
            throw new IllegalArgumentException();
        }
        if (discStrategy == null) {
            throw new NullPointerException();
        } else if (!(discStrategy instanceof DiscountStrategy)) {
            throw new IllegalArgumentException();
        }        
        receipt = new Receipt(productId, qty, custId, issueGiftReceipt,
                discStrategy);
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
    
    public final void addItemToSale(String productId, int qty, 
            boolean issueGiftReceipt, DiscountStrategy discStrategy) {
        if (productId == null) {
            throw new NullPointerException();
        } else if (productId.length() == 0){
            throw new IllegalArgumentException();
        }
        if (qty < 0){
            throw new IllegalArgumentException();
        }
        if (discStrategy == null) {
            throw new NullPointerException();
        } else if (!(discStrategy instanceof DiscountStrategy)) {
            throw new IllegalArgumentException();
        }        
        receipt.addLineItem(productId, qty, issueGiftReceipt, discStrategy);
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
