package lang.string.test;

public class TestString11 {

    public static void main(String[] args) {
        String str = "Hello World!";

        String string = new StringBuilder(str).reverse().toString();

//        StringBuilder sb = new StringBuilder();
//        StringBuilder reverse = sb.append(str).reverse();
        System.out.println("reverse = " + string);


    }
}
