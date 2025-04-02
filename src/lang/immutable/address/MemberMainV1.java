package lang.immutable.address;


public class MemberMainV1 {

    public static void main(String[] args) {
        Address address = new Address("서울");

        MemberV1 memberA = new MemberV1("memberA", address);
        MemberV1 memberB = new MemberV1("memberB", address);

        // 회원 A, B 처음 주소는 모두 서울
        System.out.println("memberA = " + memberA);
        System.out.println("memberB = " + memberB);

        // 회원 B 주소 부산으로 이동해야함
        memberB.getAddress().setValue("부산");
        System.out.println("부산 -> memberB.address");

        System.out.println("memberA = " + memberA); // busan
        System.out.println("memberB = " + memberB); // busan


    }
}
