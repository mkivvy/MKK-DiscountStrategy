package mkk.discountstrategy;

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
        this.qty = qty;
        this.issueGiftReceipt = issueGiftReceipt;
    }

    public double getDiscount() {
        return product.getDiscount();
    }
    
    public String getFormattedLine() {
        //need to format dollar amts
        double unitCost = product.getUnitCost();
        double extendedCost = unitCost * qty;
        double discount = product.getDiscount();
        double cost = extendedCost-discount;
        return product.getProductId() + "\t" + product.getProductName()
                + "\t" + qty + "\t" + unitCost + "\t" + extendedCost
                + "\t" + discount + "\t" + cost;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public boolean isGiftReceipt() {
        return issueGiftReceipt;
    }

    public void setGiftReceipt(boolean issueGiftReceipt) {
        this.issueGiftReceipt = issueGiftReceipt;
    }
    
    public static void main(String[] args) {
        LineItem lineItem = new LineItem("1357", 5, false);
        System.out.println(lineItem.getFormattedLine());
    }
}
