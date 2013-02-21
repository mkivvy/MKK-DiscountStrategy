package mkk.discountstrategy;

/**
 *
 * @author Mary
 */
public class Product {
    
    private String productId;
    private String productName;
    private double unitCost;
    private DiscountStrategy discStrategy;
    private int qty;

    public Product(String productId, String productName, double unitCost, 
            DiscountStrategy discStrategy, int qty) {
        this.productId = productId;
        this.productName = productName;
        this.unitCost = unitCost;
        this.discStrategy = discStrategy;
        this.qty = qty;
    }

    public Product(String productId, int qty) {
        this.productId = productId;
        //use the productId to obtain the other product info from fake database
        this.qty = qty;
    }

    public double getDiscount() {
        return discStrategy.getDiscount(unitCost, qty);
    }
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }
    
    public static void main(String[] args) {
        Product prod = new Product("2468", "Athletic socks", 5.00, 
                new FlatPercentageDiscount(), 4);
        double discount = prod.getDiscount();
        System.out.println(discount);
    }
}
