package mkk.discountstrategy;

/**
 *
 * @author Mary
 */
public class FakeCustomerDatabase {
    private Customer[] customers = {
            new Customer("100","Carter Kane",0.00),
            new Customer("200","Sadie Kane",120.35),
            new Customer("300","Amos Set",255.75),
            new Customer("400","Zia Rashid",63.33),
            new Customer("500","Michele DeJardin",500.00),
    };
    
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
