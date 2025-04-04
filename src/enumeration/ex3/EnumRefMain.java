package enumeration.ex3;

public class EnumRefMain {
    public static void main(String[] args) {
        System.out.println("class Basic :" + Grade.BASIC.getClass());
        System.out.println("class Gold :" + Grade.GOLD.getClass());
        System.out.println("class Diamond :" + Grade.DIAMOND.getClass());

        System.out.println("ref Basic : " + refValue(Grade.BASIC));
        System.out.println("ref Gold : " + refValue(Grade.GOLD));
        System.out.println("ref Diamond :" + refValue(Grade.DIAMOND));
    }

    private static String refValue(Object grade) {
        return Integer.toHexString(System.identityHashCode(grade));
    }
}
