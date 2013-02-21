package mkk.discountstrategy;

/**
 *
 * @author Mary
 */
public class LineItem {
    private Product product;
    private int qty;
    private boolean giftReceipt = false;

    public LineItem(String prodId, int qty, boolean giftReceipt) {
        product = new Product(prodId, qty);
        this.qty = qty;
        this.giftReceipt = giftReceipt;
    }

    public double getDiscount() {
        return product.getDiscount();
    }
    
    public String getFormattedLine() {
        //need to format dollar amts
        double extendedCost = product.getUnitCost() * qty;
        double discount = product.getDiscount();
        double cost = extendedCost-discount;
        return product.getProductId() + "/t" + product.getProductName()
                + "/t" + qty + "/t" + product.getUnitCost() + "/t" + extendedCost
                + "/t" + discount + "/t" + cost;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public boolean isGiftReceipt() {
        return giftReceipt;
    }

    public void setGiftReceipt(boolean giftReceipt) {
        this.giftReceipt = giftReceipt;
    }
    
    
}
