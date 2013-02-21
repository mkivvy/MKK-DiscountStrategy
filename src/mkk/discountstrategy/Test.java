package mkk.discountstrategy;

/**
 *
 * @author Mary
 */
public class Test {

    public static void main(String[] args) {
        DiscountStrategy disc1 = new QtyPercentagetDiscount(2);
        double myDisc1 = disc1.getDiscount(10, 1);
        System.out.println(myDisc1);

        DiscountStrategy disc2 = new QtyAmtDiscount(3);
        double myDisc2 = disc2.getDiscount(10, 7);
        System.out.println(myDisc2);

        DiscountStrategy disc3 = new FlatPercentageDiscount();
        double myDisc3 = disc3.getDiscount(20, 5);
        System.out.println(myDisc3);

        DiscountStrategy disc4 = new FlatAmtDiscount();
        double myDisc4 = disc4.getDiscount(25, 7);
        System.out.println(myDisc4);
        
    }
}
