package lang.immutable.address;

public class RefMain2 {

    public static void main(String[] args) {
        ImmutableAddress a = new ImmutableAddress("seoul");
        ImmutableAddress b = a; // 참조값 대입을 막을 순 없음
        System.out.println("a = " + a); // seoul
        System.out.println("b = " + b); // seoul

//        b.setValue("busan");
        b = new ImmutableAddress("busan");
        System.out.println("a = " + a); // seoul
        System.out.println("b = " + b); // busan

    }

}
