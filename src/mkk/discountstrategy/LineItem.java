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
        product = new Product(prodId, qty);
        setQty(qty);
        this.issueGiftReceipt = issueGiftReceipt;
    }

    public double getDiscount() {
        return product.getDiscount();
    }
    
    public String getFormattedLine() {
        DecimalFormat dollar = new DecimalFormat("#,##0.00");
        double unitCost = product.getUnitCost();
        double extendedCost = unitCost * qty;
        double discount = product.getDiscount();
        double cost = extendedCost-discount;
        return product.getProductId() 
                + "\t" + product.getProductName()
                + "\t" + qty 
                + "\t" + dollar.format(unitCost) 
                + "\t" + dollar.format(extendedCost)
                + "\t" + dollar.format(discount) 
                + "\t$" + dollar.format(cost);
    }

    public String getFormattedLineHeader() {
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
        LineItem lineItem = new LineItem("1357", 5, false);
        System.out.println(lineItem.getFormattedLineHeader());
        System.out.println(lineItem.getFormattedLine());
    }
}
