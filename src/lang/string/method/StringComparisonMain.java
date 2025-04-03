package lang.string.method;

public class StringComparisonMain {

    public static void main(String[] args) {
        String str1 = "Hello, Java!"; // 대문자 있음
        String str2 = "hello, Java!"; // 대문자 없음
        String str3 = "Hello, World!";

        System.out.println("str1 equals str2 : " + str1.equals(str2)); // false
        System.out.println("str1 equalsIgnoreCase str2 : " + str1.equalsIgnoreCase(str2)); // true

        System.out.println("'b' compareTo 'a' :" + "b".compareTo("a")); //1
        System.out.println("'c' compareTo 'a' :" + "c".compareTo("a")); //2

        System.out.println("str1 compareTo str3 :" + str1.compareTo(str3));
        System.out.println("str1 compareTo str2 :" + str1.compareToIgnoreCase(str2));

        System.out.println("str1 starts with 'hello' :" + str1.startsWith("Hello"));


    }

}
