package lang.immutable.address;

public class RefMain1_1 {

    public static void main(String[] args) {
        // 참조형 변수는 하나의 인스턴스를 공유할 수 있음
        Address a = new Address("seoul");
        Address b = a;
        System.out.println("a = " + a); // seoul
        System.out.println("b = " + b); // seoul

        b.setValue("busan");
        System.out.println("a = " + a); // busan
        System.out.println("b = " + b); // busan

    }

}
