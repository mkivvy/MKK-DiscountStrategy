package mkk.discountstrategy;

/**
 * CustomerFakeDatabaseRetrieval uses the DataRetrievalStrategy interface to
 * create a class to retrieve Customer data from the FakeCustomerDatabase class
 * using the customer id passed in as the search key.
 *
 * @author Mary King, mking@my.wctc.edu
 * @version 1.0
 */
public class CustomerFakeDatabaseRetrieval implements DataRetrievalStrategy {

    /**
     * Instantiates an instance of the FakeCustomerDatabase and calls its
     * findCustomer method passing in a customer id to find matching Customer
     * information.
     *
     * @param customerId the customer id, a unique string identifying the
     * customer. not null, not empty
     * @return a Customer object if a matching customer id is found within the
     * the FakeCustomerDatabase, null if not found
     * @throws NullPointerException if customer id is null
     * @throws IllegalArgumentException if customer id has length of zero
     */
    @Override
    public Object getData(String customerId) {
        if (customerId == null) {
            throw new NullPointerException();
        } else if (customerId.length() == 0) {
            throw new IllegalArgumentException();
        }

        FakeCustomerDatabase db = new FakeCustomerDatabase();
        Customer customer = db.findCustomer(customerId);
        return customer;
    }
}
