package lang.immutable.address;

public class PrimitiveMain {

    public static void main(String[] args) {
        // 기본형은 같은 값을 공유하지 않음
        int a = 10;
        int b = a;

        System.out.println("a = " + a); // 10
        System.out.println("b = " + b); // 10

        b = 20;
        System.out.println("a = " + a); // 10
        System.out.println("b = " + b); // 20

    }

}
