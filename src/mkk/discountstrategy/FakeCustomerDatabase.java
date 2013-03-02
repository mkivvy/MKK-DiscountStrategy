package mkk.discountstrategy;

/**
 * FakeCustomerDatabase contains an array of initialized Customer objects for use
 * as test data for the MKK-DiscountStrategy Project.
 * The method findCustomer is used to search the Customer array for a matching
 * customer id.
 * 
 * @author Mary King, mking@my.wctc.edu
 * @version 1.0
 */
public class FakeCustomerDatabase {
    private Customer[] customers = {
            new Customer("100","Carter Kane",0.00),
            new Customer("200","Sadie Kane",120.35),
            new Customer("300","Amos Set",255.75),
            new Customer("400","Zia Rashid",63.33),
            new Customer("500","Michele DeJardin",500.00),
    };
    
    /**
     * Searches the Customer array using the customer id passed in to find a 
     * matching Customer.
     * 
     * @param custId  the customer id, a unique string identifying the customer.
     *                not null, not empty 
     * @return  a Customer object if a matching customer id is found within the
     *          the array, null if not found
     * @throws NullPointerException if customer id is null 
     * @throws  IllegalArgumentException if customer id has length of zero
     */
    public final Customer findCustomer(String custId){
        if (custId == null) {
            throw new NullPointerException();
        } else if (custId.length() == 0){
            throw new IllegalArgumentException();
        }
        Customer customer = null;
        for (Customer cust : customers) {
            if (custId.equals(cust.getCustomerId())){
                customer = cust;
                break;
            }
        }
        return customer;
    }
}
