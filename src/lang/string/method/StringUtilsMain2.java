package lang.string.method;

public class StringUtilsMain2 {

    public static void main(String[] args) {
        int num = 100;
        boolean bool = true;
        Object object = new Object();
        String str = "Hello, Java!";

        String format1 = String.format("num = %d, bool: %b, str: %s", num, bool, str);
        System.out.println("format1 = " + format1);

        String format2 = String.format("숫자 : %.2f", 10.1234);
        System.out.println("format2 = " + format2);

        // printf
        System.out.printf("숫자: %.3f\n", 10.1234);

        // matches
        String regex = "Hello, (Java!|World)";
        System.out.println("str 이 패턴과 매치되는가? " + str.matches(regex));

    }
}
