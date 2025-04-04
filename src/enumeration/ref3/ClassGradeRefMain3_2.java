package enumeration.ref3;

public class ClassGradeRefMain3_2 {

    public static void main(String[] args) {
        int price = 10000;

        System.out.println("Basic: " + Grade.BASIC.discount(price));
        System.out.println("Gold: " + Grade.GOLD.discount(price));
        System.out.println("Diamond: " + Grade.DIAMOND.discount(price));
    }
}
