package mkk.discountstrategy;

/**
 *
 * @author Mary
 */
public class FakeDatabase {
    private Customer[] customers = {
            new Customer("100","Carter Kane",0.00),
            new Customer("200","Sadie Kane",120.35),
            new Customer("300","Amos Set",255.75),
            new Customer("400","Zia Rashid",63.33),
            new Customer("500","Michele DeJardin",500.00),
    };
    
    private Product[] products = {
            new Product("A1234","Black T-shirt",5.00, new NoDiscount()),
            new Product("B2345","GB Packers T-shirt",12.99, new QtyAmtDiscount(3)),
            new Product("C3456","Badgers T-shirt",12.99, new QtyAmtDiscount(2)),
            new Product("D4567","Red baseball cap",9.99, new FlatAmtDiscount()),
            new Product("E5678","Nike athletic shoes",84.99, new NoDiscount()),
            new Product("F6789","Women's Lee jeans",32.99, new FlatPercentageDiscount()),
            new Product("G7890","Men's Levi jeans",36.99, new FlatPercentageDiscount()),
            new Product("H8901","Athletic socks",6.99, new FlatAmtDiscount()),
            new Product("I9012","Gold hoop earrings",12.00, new QtyPercentageDiscount(3)),
            new Product("J0123","Silver hoop earrings",10.00, new QtyPercentageDiscount(2))
    };
    
    public final Product findProduct(String prodId){
        if (prodId == null) {
            throw new NullPointerException();
        } else if (prodId.length() == 0){
            throw new IllegalArgumentException();
        }
        Product product = null;
        for (Product prod : products) {
            if (prodId.equals(prod.getProductId())){
                product = prod;
                break;
            }
        }
        return product;
    }

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
