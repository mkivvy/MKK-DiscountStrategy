package mkk.discountstrategy;

/**
 *
 * @author Mary
 */
public class ProductMapRetrieval implements DataRetrievalStrategy {

    @Override
    public Object getData(String productId) {
        if (productId == null) {
            throw new NullPointerException();
        } else if (productId.length() == 0){
            throw new IllegalArgumentException();
        }
        
        ProductMap fpm = new ProductMap();
        Product product = fpm.findProduct(productId);
        return product;
    }
}
