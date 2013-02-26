package mkk.discountstrategy;

import java.text.DecimalFormat;

/**
 *
 * @author Mary
 */
public class Receipt {

    private LineItem[] lineItems = new LineItem[1];
    private Customer customer;
    private double totalDiscountAmt = 0.0;
    private double totalActualCost = 0.0;

    public Receipt(String prodId, int qty, String custId) {
        if (prodId == null) {
            throw new NullPointerException();
        } else if (prodId.length() == 0) {
            throw new IllegalArgumentException();
        }
        if (qty < 0) {
            throw new IllegalArgumentException();
        }

        lineItems[0] = new LineItem(prodId, qty);

        setCustomerId(custId);
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

        lineItems[0] = new LineItem(prodId, qty);
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
    
    public final void addLineItem(String prodId, int qty) {
        if (prodId == null) {
            throw new NullPointerException();
        } else if (prodId.length() == 0) {
            throw new IllegalArgumentException();
        }
        if (qty < 0) {
            throw new IllegalArgumentException();
        }

        LineItem item = new LineItem(prodId, qty);
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
        System.out.println(lineItems[0].getFormattedLineHeader());
        for (LineItem li : lineItems) {
            System.out.println(li.getFormattedLine());
            if (li.isGiftReceipt()){
                //do gift receipt 
            }
        }
        printTotals();
        printCustomerMsgLines();
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
                + ((name != null) ? name: " ") + "!");
        System.out.println("You saved $" + dollar.format(totalDiscountAmt) + "!");
        System.out.println("\n\n");
    }
    
    public static void main(String[] args) {
        Receipt r = new Receipt("I9012", 3, "200");
        r.addLineItem("J0123", 2);
        r.addLineItem("B2345", 3);
        r.addLineItem("F6789", 1);
        r.produceReceipt();
    }
}
