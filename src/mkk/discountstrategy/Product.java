package mkk.discountstrategy;

/**
 * Product is a concrete class containing data and methods related to a single
 * item in a retail system for the MKK-DiscountStrategy Project.
 * In addition to the basic product fields product id, product name, and
 * product unit cost, it also references a DiscountStrategy to determine the
 * product-specific discount.
 * A DataRetrievalStrategy is also used for obtaining the product data from the
 * product database.
 * <p>
 * Quantity is the amount of the specific items being purchased.
 * This is passed into this class for use in calculating costs and discount.
 * 
 * @author Mary King, mking@my.wctc.edu
 * @version 1.0
 */
public class Product {
    
    private String productId;
    private String productName;
    private double unitCost;
    private DiscountStrategy discStrategy;
    private int qty;
    private DataRetrievalStrategy dataStrategy 
            = new ProductFakeMapRetrieval();
//            = new ProductFakeDatabaseRetrieval();

    /**
     * Constructor instantiates the class setting the product id value, product 
     * name, product's unit cost, discount strategy, and quantity private fields. 
     * This constructor does not require product information to be retrieved 
     * from the product database.
     * 
     * @param productId  the product id, a unique string identifying the product.
     *                   not null, not empty
     * @param productName  the descriptive name of the product. not null, not empty
     * @param unitCost  the cost of one unit of the item being purchased
     * @param discStrategy  the discount strategy type of class being used to 
     *                      calculate the discount for this particular product.
     * @param qty  the number of the item being purchased
     */
    public Product(String productId, String productName, double unitCost, 
            DiscountStrategy discStrategy, int qty) {
        setProductId(productId);
        setProductName(productName);
        setUnitCost(unitCost);
        setDiscStrategy(discStrategy);
        setQty(qty);
    }

    /**
     * Constructor instantiates the class setting the product id value and
     * quantity private fields.  
     * The remaining product information is then retrieved from the product
     * database using the data retrieval strategy.
     * 
     * @param productId  the product id, a unique string identifying the product.
     *                   not null, not empty
     * @param qty  the number of the item being purchased
     * @throws  NullPointerException if a Product object is not returned when
     *          looking up product information
     */
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

    /**
     * Constructor instantiates the class setting the product id value, product 
     * name, product's unit cost, and discount strategy private fields.  
     * If this constructor is used, the product quantity must be set separately
     * in order for the discount calculation to work properly.
     * 
     * @param productId  the product id, a unique string identifying the product.
     *                   not null, not empty
     * @param productName  the descriptive name of the product. not null, not empty
     * @param unitCost  the cost of one unit of the item being purchased
     * @param discStrategy  the discount strategy type of class being used to 
     *                      calculate the discount for this particular product.
     */
    public Product(String productId, String productName, double unitCost, 
            DiscountStrategy discStrategy) {
        setProductId(productId);
        setProductName(productName);
        setUnitCost(unitCost);
        setDiscStrategy(discStrategy);
    }

    /**
     * Calculates the discount amount for the quantity of the product being 
     * purchased using the product's unit cost and discount strategy
     * 
     * @param unitCost  the cost of one unit of the item being purchased
     * @param qty  the number of the item being purchased
     * @return  the dollar and cents calculated discount amount for the entire
     *          quantity of the product being purchased 
     */
    public final double getDiscount() {
        return discStrategy.getDiscount(unitCost, qty);
    }
    
    private Product getProductInfo(String prodId) {
        //prodId does not need to be validated here because this is a private
        //method called only from the constructor which already validates it
        //COOL!!! I am making use of the strategy pattern AND polymorphism!
        Object obj = dataStrategy.getData(prodId);
        if (obj instanceof Product) {
            Product product = (Product) obj;
            return product;
        } else {
            throw new IllegalArgumentException();
        }
        
    }
    
    /**
     * Returns the value of the private variable for the unique identifier of the
     * product being purchased.
     * 
     * @return  the value of the private variable for the unique identifier of 
     *          the product, null if not set
     */
    public final String getProductId() {
        return productId;
    }

    /**
     * Sets the value of the private variable for the unique identifier of the
     * product being purchased.
     * 
     * @param productId  the product id, a unique string identifying the product.
     *                   not null, not empty
     * @throws  NullPointerException if the productId parameter is null
     * @throws  IllegalArgumentException if the productId parameter is empty
     */
    public final void setProductId(String productId) {
        if (productId == null) {
            throw new NullPointerException();
        } else if (productId.length() == 0){
            throw new IllegalArgumentException();
        } else {
            this.productId = productId;
        }
    }

    /**
     * Returns the value of the private variable for the descriptive name of the
     * product being purchased.
     * 
     * @return  the descriptive name of the product, null if not set
     */
    public final String getProductName() {
        return productName;
    }

    /**
     * Sets the value of the private variable for the descriptive name of the
     * product being purchased.
     * 
     * @param productName  the descriptive name of the product. not null, not empty
     * @throws  NullPointerException if the productName parameter is null
     * @throws  IllegalArgumentException if the productName parameter is empty
     */
    public final void setProductName(String productName) {
        if (productName == null) {
            throw new NullPointerException();
        } else if (productName.length() == 0){
            throw new IllegalArgumentException();
        } else {
            this.productName = productName;
        }
    }

    /**
     * Returns the value of the private variable for unit cost of the item purchased.
     * 
     * @return  the cost of one unit of the item being purchased, null if not set
     */
    public final double getUnitCost() {
        return unitCost;
    }

    /**
     * Sets the value of the private variable for unit cost of the item purchased.
     * If the value passed in is less than 0, it is set to 0.0.
     * 
     * @param unitCost  the cost of one unit of the item being purchased
     */
    public final void setUnitCost(double unitCost) {
        if (unitCost < 0.0) {
            this.unitCost = 0.0;
        } else {
            this.unitCost = unitCost;
        }
    }

    /**
     * Returns the value of the private variable for the discount strategy type 
     * of class to be used for calculating this particular product's discount.
     * 
     * @return  the discount strategy type of class being used to calculate the
     *          the discount amount for this particular product, null if not set
     */
    public final DiscountStrategy getDiscStrategy() {
        return discStrategy;
    }

    /**
     * Sets the value of the private variable for the discount strategy type of 
     * class to be used for calculating this particular product's discount.
     * 
     * @param discStrategy  the discount strategy type of class being used to 
     *                      calculate the discount for this particular product.
     *                      not null, not empty
     * @throws  NullPointerException if discStrategy parameter is null
     * @throws  IllegalArgumentException if discStrategy parameter is empty
     */
    public final void setDiscStrategy(DiscountStrategy discStrategy) {
        if (discStrategy == null) {
            throw new NullPointerException();
        } else if (!(discStrategy instanceof DiscountStrategy)) {
            throw new IllegalArgumentException();
        } else {
            this.discStrategy = discStrategy;
        }
    }

    /**
     * Returns the value of the private variable for the data retrieval strategy
     * type of class to be used for obtaining the product information.
     * 
     * @return  the data retrieval strategy type of class being used for
     *          obtaining the product information, null if not set
     */
    public DataRetrievalStrategy getDataStrategy() {
        return dataStrategy;
    }

    /**
     * Sets the value of the private variable for the data retrieval strategy
     * type of class to be used for obtaining the product information.
     * 
     * @param dataStrategy  the data retrieval strategy type of class being used 
     *                      for obtaining the product information.
     *                      not null, not empty
     * @throws  NullPointerException if dataStrategy parameter is null
     * @throws  IllegalArgumentException if dataStrategy parameter is empty
     */
    public void setDataStrategy(DataRetrievalStrategy dataStrategy) {
        if (discStrategy == null) {
            throw new NullPointerException();
        } else if (!(discStrategy instanceof DiscountStrategy)) {
            throw new IllegalArgumentException();
        }
        this.dataStrategy = dataStrategy;
    }

    /**
     * Returns the value of the private variable for quantity of the item purchased.
     * 
     * @return  the number of the item being purchased, null if not set
     */
    public final int getQty() {
        return qty;
    }

    /**
     * Sets the value of the private variable for quantity of the item purchased.
     * If the value passed in is less than 0, it is set to 0.
     * 
     * @param qty  the number of the item being purchased
     */
    public final void setQty(int qty) {
        if (qty < 0) {
            this.qty = 0;
        } else {
            this.qty = qty;
        }
    }
    
    public static void main(String[] args) {
        Product prod = new Product("G7890", 4);
        System.out.println(prod.getProductId());
        System.out.println(prod.getProductName());
        System.out.println(prod.getUnitCost());
        System.out.println(prod.discStrategy);
        double discount = prod.getDiscount();
        System.out.println(discount);
    }
}
