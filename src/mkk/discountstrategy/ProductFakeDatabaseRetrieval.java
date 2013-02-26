package mkk.discountstrategy;

public class ProductFakeDatabaseRetrieval implements DataRetrievalStrategy {

    @Override
    public Object getData(String key) {
        FakeProductDatabase db = new FakeProductDatabase();
        Product product = db.findProduct(key);
        return product;
    }
}
