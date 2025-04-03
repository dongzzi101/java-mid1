package lang.string.method;

public class StringUtilsMain1 {

    public static void main(String[] args) {
        int num = 100;
        boolean bool = true;
        Object object = new Object();
        String str = "Hello Java!";

        // valueOf
        String numString = String.valueOf(num);
        System.out.println("숫자의 문자열 값:  = " + numString);

        String boolStr = String.valueOf(bool);
        System.out.println("boolStr = " + boolStr);

        String stringObj = String.valueOf(object);
        System.out.println("stringObj = " + stringObj);

        // 문자 + x -> 문자
        String numString2 = "" + num;
        System.out.println("numString2 = " + numString2);

        // toCharArray
        char[] strCharArray = str.toCharArray();
        System.out.println("strCharArray = " + strCharArray);
        for (char c : strCharArray) {
            System.out.print(c);
        }
    }
}
