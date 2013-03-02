package mkk.discountstrategy;
/**
 * ProductFakeDatabaseRetrieval uses the DataRetrievalStrategy interface to 
 * create a class to retrieve Product data from the FakeProductDatabase class
 * using the product id passed in as the search key.
* 
 * @author Mary King, mking@my.wctc.edu
 * @version 1.0
*/
public class ProductFakeDatabaseRetrieval implements DataRetrievalStrategy {

    /**
     * Instantiates an instance of the FakeProductDatabase and calls its
     * findProduct method passing in a product id to find matching Product
     * information.
     * 
     * @param productId  the product id, a unique string identifying the product.
     *                   not null, not empty 
     * @return  a Product object if a matching product id is found within the
     *          the FakeProductDatabase, otherwise null
     * @throws  NullPointerException if product id is null 
     * @throws  IllegalArgumentException if product id has length of zero
     */
    @Override
    public Object getData(String productId) {
        if (productId == null) {
            throw new NullPointerException();
        } else if (productId.length() == 0){
            throw new IllegalArgumentException();
        }
        
        FakeProductDatabase db = new FakeProductDatabase();
        Product product = db.findProduct(productId);
        return product;
    }
}
