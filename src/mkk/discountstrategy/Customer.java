package mkk.discountstrategy;

/**
 * Customer is a concrete class containing data and methods related to a 
 * customer in a retail system for the MKK-DiscountStrategy Project.
 * A DataRetrievalStrategy is also used for obtaining the customer data from the
 * product database.
 * 
 * @author Mary King, mking@my.wctc.edu
 * @version 1.0
 */
public class Customer {

    private String customerId;
    private String customerName;
    private double acctBalance = 0.0;
//    private DataRetrievalStrategy dataStrategy = new CustomerFakeDatabaseRetrieval();
    private DataRetrievalStrategy dataStrategy = new CustomeMapRetrieval();

    /**
     * Constructor instantiates the class using the customer id and customer name.
     * 
     * @param customerId  the customer id, a unique string identifying the 
     *                    customer, not null, not empty
     * @param customerName  the first and last name of the customer, 
     *                      not null, not empty
     */
    public Customer(String customerId, String customerName) {
        setCustomerId(customerId);
        setCustomerName(customerName);
    }

    /**
     * Constructor instantiates the class using the customer id, customer name,
     * and account balance.
     * 
     * @param customerId  the customer id, a unique string identifying the 
     *                    customer, not null, not empty
     * @param customerName  the first and last name of the customer, 
     *                      not null, not empty
     * @param acctBalance  the customer's account balance (not used at this
     *                     point in the project). can be zero or less or more
     */
    public Customer(String customerId, String customerName, double acctBalance) {
        setCustomerId(customerId);
        setCustomerName(customerName);
        setAcctBalance(acctBalance);
    }

    /**
     * Constructor instantiates the class using just the customer id.  The
     * customer id is then used to look up the rest of the customer information
     * in the customer database.
     * 
     * @param customerId  the customer id, a unique string identifying the 
     *                    customer, not null, not empty
     * @throws  NullPointerException if a Customer object is not returned when
     *          looking up customer information
     */
    public Customer(String customerId) {
        setCustomerId(customerId);
        Customer customer = getCustomerInfo(customerId);
        if (customer == null) {
            throw new NullPointerException();
        }
        setCustomerId(customer.customerId);
        setCustomerName(customer.customerName);
        setAcctBalance(customer.acctBalance);
    }

    /**
     * Increments the balance in the customer's account.
     * 
     * @param amt  the amount the customer's account is to be debited 
     */
    public final void debitAcct(double amt) {
        acctBalance += amt;
    }

    /**
     * Decrements the balance in the customer's account.
     * 
     * @param amt  the amount the customer's account is to be credited 
     */
    public final void creditAcct(double amt) {
        acctBalance -= amt;
    }

    private Customer getCustomerInfo(String custId) {
        //prodId does not need to be validated here because this is a private
        //method called only from the constructor which already validates it
        //COOL!!! I am making use of the strategy pattern AND polymorphism!
        Object obj = dataStrategy.getData(custId);
        if (obj instanceof Customer) {
            Customer customer = (Customer) obj;
            return customer;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public final String getCustomerId() {
        return customerId;
    }

    public final void setCustomerId(String customerId) {
        if (customerId == null) {
            throw new NullPointerException();
        } else if (customerId.length() == 0) {
            throw new IllegalArgumentException();
        } else {
            this.customerId = customerId;
        }
    }

    public final String getCustomerName() {
        return customerName;
    }

    public final void setCustomerName(String customerName) {
        if (customerName == null) {
            throw new NullPointerException();
        } else if (customerName.length() == 0) {
            throw new IllegalArgumentException();
        } else {
            this.customerName = customerName;
        }
    }

    public final double getAcctBalance() {
        return acctBalance;
    }

    public final void setAcctBalance(double acctBalance) {
        //acctBalance can be less than zero as customer may pre-pay, can be
        //zero, and can be more than zero - in the real world we'd probably
        //want to set an alert of some kind if the balance was too high or
        //too low, but for this project as long as the balance is a double,
        //it's valid
        this.acctBalance = acctBalance;
    }

    public DataRetrievalStrategy getDataStrategy() {
        return dataStrategy;
    }

    public void setDataStrategy(DataRetrievalStrategy dataStrategy) {
        this.dataStrategy = dataStrategy;
    }

    public static void main(String[] args) {
        Customer cust = new Customer("500");
        System.out.println(cust.getCustomerId());
        System.out.println(cust.getCustomerName());
        System.out.println(cust.getAcctBalance());

//        Customer cust1 = new Customer("223", "Ariana King");
//        System.out.println(cust1.getCustomerId());
//        System.out.println(cust1.getCustomerName());
//        System.out.println(cust1.getAcctBalance());
//        cust1.setAcctBalance(20.00);
//        System.out.println(cust1.getAcctBalance());
//        cust1.debitAcct(5.00);
//        System.out.println(cust1.getAcctBalance());
//        cust1.creditAcct(25.01);
//        System.out.println(cust1.getAcctBalance());
//        
//        Customer cust2 = new Customer("728", "Malaya King", 10.00);
//        System.out.println(cust2.getCustomerId());
//        System.out.println(cust2.getCustomerName());
//        System.out.println(cust2.getAcctBalance());
//        cust2.debitAcct(5.00);
//        System.out.println(cust2.getAcctBalance());
//        cust2.creditAcct(15.00);
//        System.out.println(cust1.getAcctBalance());

    }
}
