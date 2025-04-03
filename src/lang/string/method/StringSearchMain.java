package lang.string.method;

public class StringSearchMain {

    public static void main(String[] args) {
        String str = "Hello, Java! Welcome to Java World!";

        System.out.println("문자열에 java 있는지: " + str.contains("Java"));
        System.out.println("java 의 첫 번째 인덱스 : "+ str.indexOf("Java"));
        System.out.println("인덱스 10부터 java의 인덱스: " + str.indexOf("Java", 10));
        System.out.println("java 의 마지막 인덱스: " + str.lastIndexOf("Java"));

    }
}
