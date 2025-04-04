package enumeration.ex1;

public class StringGradeEx1_1 {

    public static void main(String[] args) {
        int price = 10000;

        DiscountService discountService = new DiscountService();
        int basicDiscountPrice = discountService.discount(StringGrade.BASIC, price);
        int goldDiscountPrice = discountService.discount(StringGrade.GOLD, price);
        int diamondDiscountPrice = discountService.discount(StringGrade.DIAMOND, price);

        System.out.println("Basic: " + basicDiscountPrice);
        System.out.println("Gold: " + goldDiscountPrice);
        System.out.println("Diamond: " + diamondDiscountPrice);

    }
}
