package mkk.discountstrategy;

public class CustomeMapRetrieval implements DataRetrievalStrategy {

    @Override
    public Object getData(String customerId) {
        if (customerId == null) {
            throw new NullPointerException();
        } else if (customerId.length() == 0) {
            throw new IllegalArgumentException();
        }

        CustomerMap fcm = new CustomerMap();
        Customer customer = fcm.findCustomer(customerId);
        return customer;
    }
}
