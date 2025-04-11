package nested.anonymous.ex;

public class Ex1Main {

    public static void main(String[] args) {
        greet("java");
        greet("spring");
    }

    public static void greet(String name) {
        System.out.println("프로그램 시작");
        hello(name);
        System.out.println("프로그램 종료");
    }

    public static void hello(String name) {
        System.out.println("hello " + name);
    }

}
