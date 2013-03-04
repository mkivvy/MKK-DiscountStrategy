package mkk.discountstrategy;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Receipt is a concrete class containing data and methods related to a customer
 * receipt in a retail system for the MKK-DiscountStrategy Project.
 * <p>
 * Receipt contains an array of LineItem objects which print on the receipt 
 * displaying the product, quantity, cost, and discount amount for each item purchased.
 * Header and footer information is also printed on the receipt including a 
 * total amount the customer saved on this sale.
 * <p>
 * Receipt instantiates a Customer object to retrieve customer information for the
 * receipt footer to display.
 * <p>
 * This class also contains a static receipt number which increments for each new
 * receipt and a store number with a default value.
 * <p>
 * Once a receipt is printed, the line items are checked to see if any gift
 * receipts are needed and instantiates to the GiftReceipt class to print them.
 * 
 * @author Mary King, mking@my.wctc.edu
 * @version 1.0
 */
public class Receipt {

    private static double receiptNum = 0.0;  //thanks to Mark V for this idea!
    private LineItem[] lineItems = new LineItem[0];
    private Customer customer;
    private double totalDiscountAmt = 0.0;
    private double totalActualCost = 0.0;
    private String storeNum = "832252";

    /**
     * Constructor instantiates the class using the product id, quantity, issue
     * gift receipt, and a discount strategy fields to instantiate the first
     * LineItem for the receipt.
     * A Customer object is instantiated using the customer id to gather customer
     * information for the recept.
     * The issueGiftReceipt defaults to false so no gift receipts are issued.
     * The static field receipt number is incremented.
     * 
     * @param prodId  the product id, a unique string identifying the product.
     *                not null, not empty
     * @param qty  the number of the item being purchased, not less than zero
     * @param custId  the customer id, a unique string identifying the customer
     * @param issueGiftReceipt  true if a gift receipt is to be issued for the
     *                          product
     * @throws  NullPointerException if the productId parameter is null
     * @throws  IllegalArgumentException if the productId parameter is empty or
     *          the qty parameter is less than zero
     */
    public Receipt(String prodId, int qty, String custId) {
        if (prodId == null) {
            throw new NullPointerException();
        } else if (prodId.length() == 0) {
            throw new IllegalArgumentException();
        }
        if (qty < 0) {
            throw new IllegalArgumentException();
        }
        addLineItem(prodId, qty, false);

        setCustomerId(custId);
        receiptNum++;
    }

    /**
     * Constructor instantiates the class using the product id, quantity, issue
     * gift receipt, and a discount strategy fields to instantiate the first
     * LineItem for the receipt.
     * Customer id would need to be set later in the process in order to display
     * customer information on the receipt.
     * The issueGiftReceipt defaults to false so no gift receipts are issued.
     * The static field receipt number is incremented.
     * 
     * @param prodId  the product id, a unique string identifying the product.
     *                not null, not empty
     * @param qty  the number of the item being purchased, not less than zero
     * @throws  NullPointerException if the productIdparameter is null
     * @throws  IllegalArgumentException if the productId parameter is empty or
     *          the qty parameter is less than zero
     */
    public Receipt(String prodId, int qty) {
        if (prodId == null) {
            throw new NullPointerException();
        } else if (prodId.length() == 0) {
            throw new IllegalArgumentException();
        }
        if (qty < 0) {
            throw new IllegalArgumentException();
        }
        addLineItem(prodId, qty, false);
        receiptNum++;
    }

    /**
     * Constructor instantiates the class using the product id, quantity, issue
     * gift receipt, and a discount strategy fields to instantiate the first
     * LineItem for the receipt.
     * A Customer object is instantiated using the customer id to gather customer
     * information for the recept.
     * The static field receipt number is incremented.
     * 
     * @param prodId  the product id, a unique string identifying the product.
     *                not null, not empty
     * @param qty  the number of the item being purchased, not less than zero
     * @param custId  the customer id, a unique string identifying the customer
     * @param issueGiftReceipt  true if a gift receipt is to be issued for the
     *                          product
     * @throws  NullPointerException if the productId parameter is null
     * @throws  IllegalArgumentException if the productId parameter is empty or
     *          the qty parameter is less than zero
     */
    public Receipt(String prodId, int qty, String custId,
            boolean issueGiftReceipt) {
        if (prodId == null) {
            throw new NullPointerException();
        } else if (prodId.length() == 0) {
            throw new IllegalArgumentException();
        }
        if (qty < 0) {
            throw new IllegalArgumentException();
        }
        addLineItem(prodId, qty, issueGiftReceipt);

        setCustomerId(custId);
        receiptNum++;
    }

    /**
     * Constructor instantiates the class using the product id, quantity, issue
     * gift receipt, and a discount strategy fields to instantiate the first
     * LineItem for the receipt.
     * Customer id would need to be set later in the process in order to display
     * customer information on the receipt.
     * The static field receipt number is incremented.
     * 
     * @param prodId  the product id, a unique string identifying the product.
     *                not null, not empty
     * @param qty  the number of the item being purchased, not less than zero
     * @param issueGiftReceipt  true if a gift receipt is to be issued for the
     *                          product
     * @throws  NullPointerException if the productId parameter is null
     * @throws  IllegalArgumentException if the productId parameter is empty or
     *          the qty parameter is less than zero
     */
    public Receipt(String prodId, int qty, boolean issueGiftReceipt) {
        if (prodId == null) {
            throw new NullPointerException();
        } else if (prodId.length() == 0) {
            throw new IllegalArgumentException();
        }
        if (qty < 0) {
            throw new IllegalArgumentException();
        }
        addLineItem(prodId, qty, issueGiftReceipt);
        receiptNum++;
    }

    /**
     * Constructor instantiates the class using the product id, quantity, issue
     * gift receipt, and a discount strategy fields to instantiate the first
     * LineItem for the receipt.
     * Discount strategy is not a required parameter for LineItem; it is only
     * passed along if the discount strategy is to be set at the time of the sale.
     * A Customer object is instantiated using the customer id to gather customer
     * information for the recept.
     * The static field receipt number is incremented.
     * 
     * @param prodId  the product id, a unique string identifying the product.
     *                not null, not empty
     * @param qty  the number of the item being purchased, not less than zero
     * @param custId  the customer id, a unique string identifying the customer
     * @param issueGiftReceipt  true if a gift receipt is to be issued for the
     *                          product
     * @param discStrategy  the discount strategy type of class being used to 
     *                      calculate the discount for this particular product.
     *                      not null
     * @throws  NullPointerException if the productId or the discStrategy 
     *          parameter is null
     * @throws  IllegalArgumentException if the productId parameter is empty or
     *          the qty parameter is less than zero or if the discStrategy
     *          parameter is is not an instance of a DiscountStrategy type
     */
    public Receipt(String prodId, int qty, String custId,
            boolean issueGiftReceipt, DiscountStrategy discStrategy) {
        if (prodId == null) {
            throw new NullPointerException();
        } else if (prodId.length() == 0) {
            throw new IllegalArgumentException();
        }
        if (qty < 0) {
            throw new IllegalArgumentException();
        }
        if (discStrategy == null) {
            throw new NullPointerException();
        } else if (!(discStrategy instanceof DiscountStrategy)) {
            throw new IllegalArgumentException();
        }
        addLineItem(prodId, qty, issueGiftReceipt, discStrategy);

        setCustomerId(custId);
        receiptNum++;
    }

    /**
     * Constructor instantiates the class using the product id, quantity, issue
     * gift receipt, and a discount strategy fields to instantiate the first
     * LineItem for the receipt.
     * Discount strategy is not a required parameter for LineItem; it is only
     * passed along if the discount strategy is to be set at the time of the sale.
     * Customer id would need to be set later in the process in order to display
     * customer information on the receipt.
     * The static field receipt number is incremented.
     * 
     * @param prodId  the product id, a unique string identifying the product.
     *                not null, not empty
     * @param qty  the number of the item being purchased, not less than zero
     * @param issueGiftReceipt  true if a gift receipt is to be issued for the
     *                          product
     * @param discStrategy  the discount strategy type of class being used to 
     *                      calculate the discount for this particular product.
     *                      not null
     * @throws  NullPointerException if the productId or the discStrategy 
     *          parameter is null
     * @throws  IllegalArgumentException if the productId parameter is empty or
     *          the qty parameter is less than zero or if the discStrategy
     *          parameter is is not an instance of a DiscountStrategy type
     */
    public Receipt(String prodId, int qty, boolean issueGiftReceipt,
            DiscountStrategy discStrategy) {
        if (prodId == null) {
            throw new NullPointerException();
        } else if (prodId.length() == 0) {
            throw new IllegalArgumentException();
        }
        if (qty < 0) {
            throw new IllegalArgumentException();
        }
        if (discStrategy == null) {
            throw new NullPointerException();
        } else if (!(discStrategy instanceof DiscountStrategy)) {
            throw new IllegalArgumentException();
        }
        addLineItem(prodId, qty, issueGiftReceipt, discStrategy);
        receiptNum++;
    }

    public final void setCustomerId(String custId) {
        if (custId == null) {
            throw new NullPointerException();
        } else if (custId.length() == 0) {
            throw new IllegalArgumentException();
        } else {
            customer = new Customer(custId);
        }
    }

    public final String getCustomerId() {
        if (customer != null) {
            return customer.getCustomerId();
        } else {
            return null;
        }
    }

    public final void addLineItem(String prodId, int qty,
            boolean issueGiftReceipt) {
        if (prodId == null) {
            throw new NullPointerException();
        } else if (prodId.length() == 0) {
            throw new IllegalArgumentException();
        }
        if (qty < 0) {
            throw new IllegalArgumentException();
        }

        LineItem item = new LineItem(prodId, qty, issueGiftReceipt);
        addToLineItemArray(item);
    }

    public final void addLineItem(String prodId, int qty,
            boolean issueGiftReceipt, DiscountStrategy discStrategy) {
        if (prodId == null) {
            throw new NullPointerException();
        } else if (prodId.length() == 0) {
            throw new IllegalArgumentException();
        }
        if (qty < 0) {
            throw new IllegalArgumentException();
        }
        if (discStrategy == null) {
            throw new NullPointerException();
        } else if (!(discStrategy instanceof DiscountStrategy)) {
            throw new IllegalArgumentException();
        }
        LineItem item = new LineItem(prodId, qty, issueGiftReceipt, discStrategy);
        addToLineItemArray(item);
    }

    private void addToLineItemArray(LineItem item) {
        //item does not need to be validated here because this is a private
        //method that is called only from addLineItem where validation logic
        //is built into the creation of the line item
        LineItem[] tempItems = new LineItem[lineItems.length + 1];
        System.arraycopy(lineItems, 0, tempItems, 0, lineItems.length);
        tempItems[lineItems.length] = item;
        lineItems = tempItems;
    }

    public final void produceReceipt() {
        //this can also have an output strategy
        printReceiptHeader();
        for (LineItem li : lineItems) {
            System.out.println(li.getFormattedLine());
        }
        printTotals();
        printCustomerMsgLines();
        printReceiptFooter();
        printGiftReceipts();
    }

    private void printTotals() {
        calculateTotals();
        //tax calculation could also be a strategy
        double tax = calculateSalesTax();
        DecimalFormat dollar = new DecimalFormat("#,##0.00");
        System.out.println("\t\t\t\t\t\tSubtotal\t$" + dollar.format(totalActualCost));
        System.out.println("\t\t\t\t\t\tSales tax\t$" + dollar.format(tax));
        System.out.println("\t\t\t\t\t\tTotal\t\t$" + dollar.format(totalActualCost + tax));
    }

    private void calculateTotals() {
        for (LineItem li : lineItems) {
            totalDiscountAmt += li.getDiscount();
            totalActualCost += li.getActualCost();
        }
    }

    private double calculateSalesTax() {
        return totalActualCost * .051;
    }

    private void printCustomerMsgLines() {
        DecimalFormat dollar = new DecimalFormat("#,##0.00");
        String name = " ";
        if (customer != null) {
            name = customer.getCustomerName();
        }
        System.out.println("Thank you for shopping with us today, "
                + ((name != null) ? name : " ") + "!");
        System.out.println("You saved $" + dollar.format(totalDiscountAmt) + "!");
    }

    private void printReceiptHeader() {
        DecimalFormat formatter = new DecimalFormat("0000");
        System.out.println("Receipt#: " + formatter.format(receiptNum));
        System.out.println("\t\t\t-- MKK SUPERSTORES --\n");
        System.out.println(lineItems[0].getFormattedLineHeader());
    }

    private void printReceiptFooter() {
        //Format today's date with weekday, date & time 
        String fullDateTime = "EEE MM/dd/yyyy hh:mm a";
        SimpleDateFormat sdf1 = new SimpleDateFormat(fullDateTime);
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        date = calendar.getTime();
        String formattedToday = sdf1.format(date);
        //Format return by date (today + 90 days) with just weekday and date
        String dateOnly = "EEE MM/dd/yyyy";
        SimpleDateFormat sdf2 = new SimpleDateFormat(dateOnly);
        calendar.add(Calendar.DATE, 90);
        date = calendar.getTime();
        String formatted90Days = sdf2.format(date);
        
        System.out.println("\n\n\tMKK SUPERSTORES Store #" + storeNum 
                 + " " + formattedToday);
        System.out.println("\nReturns or exchanges can only be made with a "
                + "valid receipt within 90 days \nof the date of purchase. "
                + "Returns/exchanges must be done on or before\n"
                + formatted90Days + ".");
        System.out.println("\n================================================="
                + "=================================");

    }

    private void printGiftReceipts() {
        for (LineItem li : lineItems) {
            if (li.isGiftReceipt() && (li.getActualCost() > 0.0)) {
                GiftReceipt gr = new GiftReceipt(li.getProductId(),
                        li.getActualCost(), li.getQty());
                gr.produceGiftReceipt();
            }
        }
    }

    public final String getStoreNum() {
        return storeNum;
    }

    public final void setStoreNum(String storeNum) {
        if (storeNum == null) {
            throw new NullPointerException();
        } else if (storeNum.length() == 0) {
            throw new IllegalArgumentException();
        }
        this.storeNum = storeNum;
    }

    public static void main(String[] args) {
        Receipt r = new Receipt("I9012", 3, "200", true);
        r.addLineItem("J0123", 2, true);
        r.addLineItem("B2345", 3, false);
        r.addLineItem("F6789", 1, false);
        r.produceReceipt();
        Receipt r2 = new Receipt("J0123", 3, false);
        r2.addLineItem("D4567", 1, true);
        r2.setCustomerId("400");
        r2.produceReceipt();
    }
}
