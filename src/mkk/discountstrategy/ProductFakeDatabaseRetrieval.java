package mkk.discountstrategy;

public class ProductFakeDatabaseRetrieval implements DataRetrievalStrategy {

    @Override
    public Object getData(String productId) {
        FakeProductDatabase db = new FakeProductDatabase();
        Product product = db.findProduct(productId);
        return product;
    }
}
