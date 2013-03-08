package mkk.discountstrategy;

import java.util.HashMap;
import java.util.Map;

public class FakeProductMap {

    private Product[] products = {
        new Product("A1234", "Black T-shirt   ", 5.00, new NoDiscount()),
        new Product("B2345", "GB Packers T-shirt", 12.99, new QtyAmtDiscount(3)),
        new Product("C3456", "Badgers T-shirt ", 12.99, new QtyAmtDiscount(2)),
        new Product("D4567", "Red baseball cap", 9.99, new FlatAmtDiscount()),
        new Product("E5678", "Nike athletic shoes", 84.99, new NoDiscount()),
        new Product("F6789", "Women's Lee jeans", 32.99, new FlatPercentageDiscount()),
        new Product("G7890", "Men's Levi jeans", 36.99, new FlatPercentageDiscount()),
        new Product("H8901", "Athletic socks  ", 6.99, new FlatAmtDiscount()),
        new Product("I9012", "Gold hoop earrings", 12.00, new QtyPercentageDiscount(3)),
        new Product("J0123", "Silver hoop earrings", 10.00, new QtyPercentageDiscount(2))
    };

    private Map<String, Product> productMap = new HashMap<String, Product>();

    public FakeProductMap() {
        //populate the map with the array
        for (Product p : products) {
            productMap.put(p.getProductId(), p);
        }
    }
    
        public final Product findProduct(String prodId){
            return productMap.get(prodId);
        }

}
