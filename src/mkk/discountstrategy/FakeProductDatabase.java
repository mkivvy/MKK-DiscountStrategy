package mkk.discountstrategy;

/**
 * FakeProductDatabase contains an array of initialized Product objects for use
 * as test data for the MKK-DiscountStrategy Project.
 * The method findProduct is used to search the Product array for a matching
 * product id.
 * 
 * @author Mary King, mking@my.wctc.edu
 * @version 1.0
 */
public class FakeProductDatabase {
    private Product[] products = {
            new Product("A1234","Black T-shirt   ",5.00, new NoDiscount()),
            new Product("B2345","GB Packers T-shirt",12.99, new QtyAmtDiscount(3)),
            new Product("C3456","Badgers T-shirt ",12.99, new QtyAmtDiscount(2)),
            new Product("D4567","Red baseball cap",9.99, new FlatAmtDiscount()),
            new Product("E5678","Nike athletic shoes",84.99, new NoDiscount()),
            new Product("F6789","Women's Lee jeans",32.99, new FlatPercentageDiscount()),
            new Product("G7890","Men's Levi jeans",36.99, new FlatPercentageDiscount()),
            new Product("H8901","Athletic socks  ",6.99, new FlatAmtDiscount()),
            new Product("I9012","Gold hoop earrings",12.00, new QtyPercentageDiscount(3)),
            new Product("J0123","Silver hoop earrings",10.00, new QtyPercentageDiscount(2))
    };
    
    /**
     * Searches the Product array using the product id passed in to find a 
     * matching Product.
     * 
     * @param prodId  the product id, a unique string identifying the product.
     *                not null, not empty 
     * @return  a Product object if a matching product id is found within the
     *          the array, null if not found
     * @throws NullPointerException if product id is null 
     * @throws  IllegalArgumentException if product id has length of zero
     */
    public final Product findProduct(String prodId){
        if (prodId == null) {
            throw new NullPointerException();
        } else if (prodId.length() == 0){
            throw new IllegalArgumentException();
        }
        Product product = null;
        for (Product prod : products) {
            if (prodId.equals(prod.getProductId())){
                product = prod;
                break;
            }
        }
        return product;
    }

}
