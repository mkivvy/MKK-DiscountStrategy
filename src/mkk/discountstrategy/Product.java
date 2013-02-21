package mkk.discountstrategy;

/**
 *
 * @author Mary
 */
public class Product {
    
    private String productId;
    private String productName;
    private double unitCost;
    private int qty;

    public Product(String productId, String productName, double unitCost, int qty) {
        this.productId = productId;
        this.productName = productName;
        this.unitCost = unitCost;
        this.qty = qty;
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
    

}
