package enumeration.ex0;

public class StringGradeEx0_1 {

    public static void main(String[] args) {
        int price = 10000;

        DiscountService discountService = new DiscountService();
        int basicDiscountPrice = discountService.discount("BASIC", price);
        int goldDiscountPrice = discountService.discount("GOLD", price);
        int diamondDiscountPrice = discountService.discount("DIAMOND", price);

        System.out.println("Basic: " + basicDiscountPrice);
        System.out.println("Gold: " + goldDiscountPrice);
        System.out.println("Diamond: " + diamondDiscountPrice);

    }
}
