package mkk.discountstrategy;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Receipt contains an array of initialized Customer objects for use
 * as test data for the MKK-DiscountStrategy Project.
 * The method findCustomer is used to search the Customer array for a matching
 * customer id.
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
