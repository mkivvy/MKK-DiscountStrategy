package mkk.discountstrategy;


public class CustomerFakeDatabaseRetrieval implements DataRetrievalStrategy {

    @Override
    public Object getData(String customerId) {
        FakeCustomerDatabase db = new FakeCustomerDatabase();
        Customer customer = db.findCustomer(customerId);
        return customer;
    }

}
