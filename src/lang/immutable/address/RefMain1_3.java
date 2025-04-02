package lang.immutable.address;

public class RefMain1_3 {

    public static void main(String[] args) {
        // 참조형 변수는 하나의 인스턴스를 공유할 수 있음
        Address a = new Address("seoul");
        Address b = a;
        System.out.println("a = " + a); // seoul
        System.out.println("b = " + b); // seoul

        change(b, "busan");
        System.out.println("a = " + a); // busan
        System.out.println("b = " + b); // busan

    }

    private static void change(Address address, String changeAddress) {
        System.out.println("changeAddress ->" + changeAddress);
        address.setValue(changeAddress);
    }

}
