package mkk.discountstrategy;

public class ProductFakeDatabaseRetrieval implements ProductDataRetrievalStrategy {

    @Override
    public Product getProductInfo(String prodId) {
        FakeProductDatabase db = new FakeProductDatabase();
        Product product = db.findProduct(prodId);
        return product;
    }
}
