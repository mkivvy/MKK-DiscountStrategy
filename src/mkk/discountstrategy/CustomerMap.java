package mkk.discountstrategy;

import java.util.HashMap;
import java.util.Map;

public class CustomerMap {

    private Customer[] customers = {
        new Customer("100", "Carter Kane", 0.00),
        new Customer("200", "Sadie Kane", 120.35),
        new Customer("300", "Amos Set", 255.75),
        new Customer("400", "Zia Rashid", 63.33),
        new Customer("500", "Michele DeJardin", 500.00),};
    private Map<String, Customer> customerMap = new HashMap<String, Customer>();

    public CustomerMap() {
        //populate the customer map using the customers array
        for (Customer c : customers) {
            customerMap.put(c.getCustomerId(), c);
        }
    }

    public final Customer findCustomer(String custId) {
        return customerMap.get(custId);
    }
}
