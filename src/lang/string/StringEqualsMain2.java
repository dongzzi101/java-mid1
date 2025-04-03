package lang.string;

public class StringEqualsMain2 {

    public static void main(String[] args) {
        String str1 = new String("hello");
        String str2 = new String("hello");

        System.out.println("메서드 호출 비교 1 " + isSame(str1, str2)); // false

        String str3 = "hello";
        String str4 = "hello";

        System.out.println("메서드 호출 비교 2 " + isSame(str3, str4)); // true

    }

    private static boolean isSame(String str1, String str2) {
//        return str1 == str2;
        return str1.equals(str2);
    }

}
