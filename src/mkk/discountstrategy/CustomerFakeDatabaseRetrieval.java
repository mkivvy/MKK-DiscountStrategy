package mkk.discountstrategy;


public class CustomerFakeDatabaseRetrieval implements DataRetrievalStrategy {

    @Override
    public Object getData(String key) {
        FakeCustomerDatabase db = new FakeCustomerDatabase();
        Customer customer = db.findCustomer(key);
        return customer;
    }

}
