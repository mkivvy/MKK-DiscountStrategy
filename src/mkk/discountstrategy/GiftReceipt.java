package mkk.discountstrategy;

import java.text.DecimalFormat;

/**
 *
 * @author Mary
 */
public class GiftReceipt {

    private static double giftReceiptNum = 0.0;
    private String storeNum = "832252";
    private Product product;
    private double perItemCost;
    private int qty;

    //note that the ACTUAL TOTAL COST the customer paid for the entire qty is
    //what gets passed in here - therefore, per item cost for each reciept is
    //calculated by dividing cost by qty when cost is set
    public GiftReceipt(String productId, double cost, int qty) {
        if (productId == null) {
            throw new NullPointerException();
        } else if (productId.length() == 0) {
            throw new IllegalArgumentException();
        }
        if (qty < 0) {
            qty = 0;
        }
        product = new Product(productId, qty);
        setQty(qty);
        setPerItemCost(cost);
    }

    public final void produceGiftReceipt() {
        String codedCost = getCodedCost();
        //1 gift receipt is produced for each of the qty
        for (int i = 0; i < qty; i++) {
            giftReceiptNum++;
            printReceiptHeader();
            System.out.println(product.getProductId() + "\t"
                    + product.getProductName() + "\t"
                    + codedCost + "\n\n");
        }
    }

    private void printReceiptHeader() {
        DecimalFormat formatter = new DecimalFormat("0000");
        System.out.println("Gift receipt#: " + formatter.format(giftReceiptNum));
        System.out.println("\t\t\t-- MKK SUPERSTORES --\n");
    }
    
    private String getCodedCost() {
        //if this were for real, there would be an algorithim referenced here
        //that takes the actual cost paid that was passed into the constructor
        //and encodes it into a barcode - here I will just return a string of Xs
        return "XXXXX";
    }

    public final double getCost() {
        return perItemCost;
    }

    public final void setPerItemCost(double cost) {
        if (cost < 0.0) {
            this.perItemCost = 0.0;
        } else {
            this.perItemCost = cost/qty;
        }
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

    public String getStoreNum() {
        return storeNum;
    }

    public void setStoreNum(String storeNum) {
        if (storeNum == null) {
            throw new NullPointerException();
        } else if (storeNum.length() == 0) {
            throw new IllegalArgumentException();
        }
        this.storeNum = storeNum;
    }

    public static void main(String[] args) {
        GiftReceipt gr = new GiftReceipt("C3456", 37.97, 3);
        gr.produceGiftReceipt();
    }
}
