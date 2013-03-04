package mkk.discountstrategy;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
/**
 * GiftReceipt is a concrete class containing data and methods related to the
 * generation of customer-requested gift receipts in a retail system for the 
 * MKK-DiscountStrategy Project.
 * A gift receipt is generated for a product for each actual item purchased.
 * In other words, if a customer bought 3 t-shirts then 3 gift receipts are
 * created.
 * This class currently does not have the ability to generate fewer gift
 * receipts than the entire quantity purchased.
 * <p>
 * A Product object is instantiated to get needed product information but 
 * instead of using the unitCost in the Product database, a perItemCost is 
 * calculated. 
 * This is because with a discount applied, the perItemCost could differ from
 * the Product's stored unitCost.
 * <p>
 * This class also contains a static gift receipt number which increments for 
 * each new gift receipt and a store number with a default value.
 * 
 * @author Mary King, mking@my.wctc.edu
 * @version 1.0
 */
public class GiftReceipt {

    private static double giftReceiptNum = 0.0;
    private String storeNum = "832252";
    private Product product;
    private double perItemCost;
    private int qty;

    /**
     * Constructor instantiates the class using the product id, the actual cost
     * the customer paid for the entire amount of product purchased, and the
     * quantity of the product purchased.
     * 
     * @param productId  the product id, a unique string identifying the product.
     *                   not null, not empty
     * @param cost  the ACTUAL COST that the customer paid for the entire product
     *              quantity.  The per item cost for each receipt is then
     *              calculated by dividing this cost by the quantity.  The
     *              unit cost from the Product database is not used because it
     *              would not include any discount amount.
     * @param qty  the number of the item being purchased, not less than zero
     * @throws  NullPointerException if the productId parameter is null
     * @throws  IllegalArgumentException if the productId parameter is empty
     */
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
            printGiftReceiptHeader();
            System.out.println(product.getProductId() + "\t"
                    + product.getProductName() + "\t"
                    + codedCost + "\n\n");
            printGiftReceiptFooter();
        }
    }
    
    private String getCodedCost() {
        //if this were for real, there would be an algorithim referenced here
        //that takes the actual cost paid that was passed into the constructor
        //and encodes it into a barcode - here I will just return a string of Xs
        return "XXXXX";
    }

    private void printGiftReceiptHeader() {
        DecimalFormat formatter = new DecimalFormat("0000");
        System.out.println("Gift receipt#: " + formatter.format(giftReceiptNum));
        System.out.println("\t\t\t-- MKK SUPERSTORES --\n");
    }
    
    private void printGiftReceiptFooter() {
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
