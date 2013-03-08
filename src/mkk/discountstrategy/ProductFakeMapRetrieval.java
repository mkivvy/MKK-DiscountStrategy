package mkk.discountstrategy;

/**
 *
 * @author Mary
 */
public class ProductFakeMapRetrieval implements DataRetrievalStrategy {

    @Override
    public Object getData(String productId) {
        if (productId == null) {
            throw new NullPointerException();
        } else if (productId.length() == 0){
            throw new IllegalArgumentException();
        }
        
        FakeProductMap map = new FakeProductMap();
        Product product = map.findProduct(productId);
        return product;
    }
}
