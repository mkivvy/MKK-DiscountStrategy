package mkk.discountstrategy;

import java.text.DecimalFormat;

/**
 *
 * @author Mary
 */
public class Receipt {

    private LineItem[] lineItems;
    private Customer customer;
    private double totalExtendedCost = 0.0;
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

        if (custId == null) {
            throw new NullPointerException();
        } else if (custId.length() == 0) {
            throw new IllegalArgumentException();
        } else {
            customer = new Customer(custId);
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
        }
        printTotals();
        printCustomerMsgLines();
    }

    private void printTotals() {
        calculateTotals();
        //tax calculation could also be a strategy
        double tax = calculateSalesTax();
        DecimalFormat dollar = new DecimalFormat("#,##0.00");
        System.out.println("\t\t\tSubtotal\t$" + dollar.format(totalActualCost));
        System.out.println("\t\t\tSales tax\t$" + dollar.format(tax));
        System.out.println("\t\t\tTotal\t$" + dollar.format(totalActualCost + tax));
    }

    private void calculateTotals() {
        for (LineItem li : lineItems) {
            totalExtendedCost += li.getExtendedCost();
            totalDiscountAmt += li.getDiscount();
            totalActualCost += li.getActualCost();
        }
    }

    private double calculateSalesTax() {
        return totalActualCost * .051;
    }
    
    private void printCustomerMsgLines() {
        DecimalFormat dollar = new DecimalFormat("#,##0.00");
        System.out.println("Thank you for shopping with us today, " 
                + customer.getCustomerName());
        System.out.println("You saved " + dollar.format(totalDiscountAmt));
    }
    
    public static void main(String[] args) {
        Receipt r = new Receipt("I9012", 3, "200");
        r.addLineItem("J0123", 2);
        r.addLineItem("B2345", 3);
        r.addLineItem("F6789", 1);
        r.produceReceipt();
    }
}
