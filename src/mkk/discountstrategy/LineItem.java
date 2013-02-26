package mkk.discountstrategy;

import java.text.DecimalFormat;

/**
 *
 * @author Mary
 */
public class LineItem {
    private Product product;
    private int qty;
    private boolean issueGiftReceipt = false;

    public LineItem(String prodId, int qty, boolean issueGiftReceipt) {
        if (prodId == null) {
            throw new NullPointerException();
        } else if (prodId.length() == 0){
            throw new IllegalArgumentException();
        }
        if (qty < 0) {
            qty = 0;
        }
        product = new Product(prodId, qty);
        setQty(qty);
        this.issueGiftReceipt = issueGiftReceipt;
    }

    public LineItem(String prodId, int qty) {
        if (prodId == null) {
            throw new NullPointerException();
        } else if (prodId.length() == 0){
            throw new IllegalArgumentException();
        }
        if (qty < 0) {
            qty = 0;
        }
        product = new Product(prodId, qty);
        setQty(qty);
    }

    public final double getDiscount() {
        return product.getDiscount();
    }
    
    public final double getActualCost() {
        return (product.getUnitCost() * qty) - product.getDiscount();
    }

    public final double getExtendedCost() {
        return product.getUnitCost() * qty;
    }

    public final String getFormattedLine() {
        DecimalFormat dollar = new DecimalFormat("#,##0.00");
        double unitCost = product.getUnitCost();
        double extendedCost = unitCost * qty;
        double discount = product.getDiscount();
        double actualCost = extendedCost-discount;
        return product.getProductId() 
                + "\t" + product.getProductName()
                + "\t" + qty 
                + "\t" + dollar.format(unitCost) 
                + "\t" + dollar.format(extendedCost)
                + "\t" + dollar.format(discount) 
                + "\t$" + dollar.format(actualCost);
    }

    public final String getFormattedLineHeader() {
        return "Id" 
                + "\tName"
                + "\t\t\tQty"
                + "\tUnit" 
                + "\tExtCost"
                + "\tDisc"
                + "\tCost";
    }

    public final int getQty() {
        return qty;
    }

    public final void setQty(int qty) {
        if (qty < 0) {
            this.qty = 0;
        } else {
            this.qty = qty;
        }
    }

    public final boolean isGiftReceipt() {
        return issueGiftReceipt;
    }

    public final void setGiftReceipt(boolean issueGiftReceipt) {
        this.issueGiftReceipt = issueGiftReceipt;
    }
    
    public static void main(String[] args) {
        LineItem lineItem = new LineItem("F6789", 2, false);
        System.out.println(lineItem.getFormattedLineHeader());
        System.out.println(lineItem.getFormattedLine());
    }
}
