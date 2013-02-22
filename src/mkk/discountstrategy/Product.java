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
        setProductId(productId);
        setProductName(productName);
        setUnitCost(unitCost);
        setDiscStrategy(discStrategy);
        setQty(qty);
    }

    public Product(String productId, int qty) {
        setProductId(productId);
        Product product = getProductInfo(productId);
        if (product == null) {
            throw new NullPointerException();
        }
        setProductId(product.productId);
        setProductName(product.productName);
        setUnitCost(product.unitCost);
        setDiscStrategy(product.discStrategy);
        setQty(qty);
        
        //use the productId to obtain the other product info from fake database
        //for now, hard code values to pass to setters:
//        setProductName("Silver hoop earrings");
//        setUnitCost(10.00);
//        setDiscStrategy(new FlatPercentageDiscount());
    }

    public Product(String productId, String productName, double unitCost, 
            DiscountStrategy discStrategy) {
        setProductId(productId);
        setProductName(productName);
        setUnitCost(unitCost);
        setDiscStrategy(discStrategy);
    }

    public final double getDiscount() {
        return discStrategy.getDiscount(unitCost, qty);
    }
    
    private Product getProductInfo(String prodId) {
        FakeDatabase db = new FakeDatabase();
        Product product = db.findProduct(prodId);
        return product;
    }
    
    public final String getProductId() {
        return productId;
    }

    public final void setProductId(String productId) {
        if (productId == null) {
            throw new NullPointerException();
        } else if (productId.length() == 0){
            throw new IllegalArgumentException();
        } else {
            this.productId = productId;
        }
    }

    public final String getProductName() {
        return productName;
    }

    public final void setProductName(String productName) {
        if (productName == null) {
            throw new NullPointerException();
        } else if (productName.length() == 0){
            throw new IllegalArgumentException();
        } else {
            this.productName = productName;
        }
    }

    public final double getUnitCost() {
        return unitCost;
    }

    public final void setUnitCost(double unitCost) {
        if (unitCost < 0.0) {
            this.unitCost = 0.0;
        } else {
            this.unitCost = unitCost;
        }
    }

    public final DiscountStrategy getDiscStrategy() {
        return discStrategy;
    }

    public final void setDiscStrategy(DiscountStrategy discStrategy) {
        if (discStrategy == null) {
            throw new NullPointerException();
        } else if (!(discStrategy instanceof DiscountStrategy)) {
            throw new IllegalArgumentException();
        } else {
            this.discStrategy = discStrategy;
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
    
    public static void main(String[] args) {
        Product prod = new Product("A1234", 4);
        System.out.println(prod.getProductId());
        System.out.println(prod.getProductName());
        System.out.println(prod.getUnitCost());
        System.out.println(prod.discStrategy);
        double discount = prod.getDiscount();
        System.out.println(discount);
    }
}
