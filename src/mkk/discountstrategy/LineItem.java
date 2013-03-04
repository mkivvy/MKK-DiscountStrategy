package mkk.discountstrategy;

import java.text.DecimalFormat;

/**
 * LineItem is a concrete class containing data and methods related to a single
 * line item in a retail system for the MKK-DiscountStrategy Project.
 * It instantiates a Product object to retrieve product information and calculate
 * the product's discount.
 * <p>
 * Quantity is the amount of the specific items being purchased.
 * This is passed into this class for use in calculating costs and discount.
 * <p>
 * This class also contains an indicator specifying whether gift receipts are to
 * be issued.
 * 
 * @author Mary King, mking@my.wctc.edu
 * @version 1.0
 */
public class LineItem {

    private Product product;
    private int qty;
    private boolean issueGiftReceipt = false;

    /**
     * Constructor instantiates the class setting the product id, quantity, and
     * issue gift receipt private fields.  
     * 
     * @param prodId  the product id, a unique string identifying the product.
     *                not null, not empty
     * @param qty  the number of the item being purchased, not less than zero
     * @param issueGiftReceipt  true if a gift receipt is to be issued for the
     *                          product
     * @throws  NullPointerException if the productId parameter is null
     * @throws  IllegalArgumentException if the productId parameter is empty
     */
    public LineItem(String prodId, int qty, boolean issueGiftReceipt) {
        if (prodId == null) {
            throw new NullPointerException();
        } else if (prodId.length() == 0) {
            throw new IllegalArgumentException();
        }
        if (qty < 0) {
            qty = 0;
        }
        product = new Product(prodId, qty);
        setQty(qty);
        this.issueGiftReceipt = issueGiftReceipt;
    }

    /**
     * Constructor instantiates the class setting the product id, quantity, and
     * issue gift receipt private fields and passing a discount strategy to the
     * Product class to be used in calculating the product's discount.
     * 
     * @param prodId  the product id, a unique string identifying the product.
     *                not null, not empty
     * @param qty  the number of the item being purchased, not less than zero
     * @param issueGiftReceipt  true if a gift receipt is to be issued for the
     *                          product
     * @param discStrategy  the discount strategy type of class being used to 
     *                      calculate the discount for this particular product
     * @throws  NullPointerException if the productId parameter is null
     * @throws  IllegalArgumentException if the productId parameter is empty
     */
    public LineItem(String prodId, int qty, boolean issueGiftReceipt,
            DiscountStrategy discStrategy) {
        if (prodId == null) {
            throw new NullPointerException();
        } else if (prodId.length() == 0) {
            throw new IllegalArgumentException();
        }
        if (qty < 0) {
            qty = 0;
        }
        product = new Product(prodId, qty);
        setQty(qty);
        this.issueGiftReceipt = issueGiftReceipt;
        setDiscStrategy(discStrategy);
    }

    /**
     * Constructor instantiates the class setting the product id and quantity
     * private fields.
     * All other product data is to be retrieved within the Product class.
     * The issue gift receipt indicator private field is defaulted to false.
     * 
     * @param prodId  the product id, a unique string identifying the product.
     *                not null, not empty
     * @param qty  the number of the item being purchased, not less than zero
     * @throws  NullPointerException if the productId parameter is null
     * @throws  IllegalArgumentException if the productId parameter is empty
     */
    public LineItem(String prodId, int qty) {
        if (prodId == null) {
            throw new NullPointerException();
        } else if (prodId.length() == 0) {
            throw new IllegalArgumentException();
        }
        if (qty < 0) {
            qty = 0;
        }
        product = new Product(prodId, qty);
        setQty(qty);
    }

    /**
     * Calculates the discount amount for the quantity of the product being 
     * purchased using the product's unit cost and discount strategy.
     * 
     * @return  the dollar and cents calculated discount amount for the entire
     *          quantity of the product being purchased 
     */
    public final double getDiscount() {
        return product.getDiscount();
    }

    /**
     * Calculates the actual cost for the product being purchased.
     * 
     * @return  the actual cost: item's unit cost multiplied by the quantity
     *          purchased less the calculated discount amount
     */
    public final double getActualCost() {
        return (product.getUnitCost() * qty) - product.getDiscount();
    }

    /**
     * Calculates the extended cost for the product being purchased.
     * 
     * @return  the extended cost: item's unit cost multiplied by the quantity
     *          purchased
     */
    public final double getExtendedCost() {
        return product.getUnitCost() * qty;
    }

    /**
     * Formats the line item.
     * 
     * @return  the formatted string including all the values for the required
     *          line item fields
     */
    public final String getFormattedLine() {
        DecimalFormat dollar = new DecimalFormat("#,##0.00");
        double unitCost = product.getUnitCost();
        double extendedCost = unitCost * qty;
        double discount = product.getDiscount();
        double actualCost = extendedCost - discount;
        return product.getProductId()
                + "\t" + product.getProductName()
                + "\t" + qty
                + "\t" + dollar.format(unitCost)
                + "\t" + dollar.format(extendedCost)
                + "\t" + dollar.format(discount)
                + "\t$" + dollar.format(actualCost);
    }

    /**
     * Formats the line item header line.
     * 
     * @return  the formatted string including all the column headings for the
     *          line item fields
     */
    public final String getFormattedLineHeader() {
        return "Id"
                + "\tName"
                + "\t\t\tQty"
                + "\tUnit"
                + "\tExtCost"
                + "\tDisc"
                + "\tCost";
    }

    /**
     * Returns the value of the product's private variable for the unique 
     * identifier of the product being purchased.
     * 
     * @return  the value of the unique identifier of the product, null if not set
     */
    public final String getProductId() {
        return product.getProductId();
    }

    /**
     * Sets the value of the product's private  variable for the discount 
     * strategy type of class to be used for calculating this particular 
     * product's discount.
     * 
     * @param discStrategy  the discount strategy type of class being used to 
     *                      calculate the discount for this particular product.
     *                      not null, not empty
     * @throws  NullPointerException if discStrategy parameter is null
     * @throws  IllegalArgumentException if discStrategy parameter is empty
     */
    public final void setDiscStrategy(DiscountStrategy discStrategy) {
        if (discStrategy == null) {
            throw new NullPointerException();
        } else if (!(discStrategy instanceof DiscountStrategy)) {
            throw new IllegalArgumentException();
        }
        product.setDiscStrategy(discStrategy);
    }

    /**
     * Returns the value of the private variable for quantity of the item purchased.
     * 
     * @return  the number of the item being purchased, null if not set
     */
    public final int getQty() {
        return qty;
    }

    /**
     * Sets the value of the private variable for quantity of the item purchased.
     * If the value passed in is less than 0, it is set to 0.
     * 
     * @param qty  the number of the item being purchased
     */
    public final void setQty(int qty) {
        if (qty < 0) {
            this.qty = 0;
        } else {
            this.qty = qty;
        }
    }

    /**
     * Returns the value of the private variable for indicating whether a gift
     * receipt is to be issued for the product included on this line item.
     * 
     * @return  true if a gift receipt is to be issued for the product
     */
    public final boolean isGiftReceipt() {
        return issueGiftReceipt;
    }

    /**
     * Sets the value of the private variable for indicating whether a gift
     * receipt is to be issued for the product included on this line item.
     * 
     * @param issueGiftReceipt  true if a gift receipt is to be issued for the
     *                          product
     */
    public final void setGiftReceipt(boolean issueGiftReceipt) {
        this.issueGiftReceipt = issueGiftReceipt;
    }

    public static void main(String[] args) {
        LineItem lineItem = new LineItem("F6789", 2, false);
        System.out.println(lineItem.getFormattedLineHeader());
        System.out.println(lineItem.getFormattedLine());
    }
}
