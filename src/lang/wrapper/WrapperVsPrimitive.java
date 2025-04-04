package lang.wrapper;

public class WrapperVsPrimitive {

    public static void main(String[] args) {
        int iterations = 1_000_000_000; // 반복 횟수
        long startTime, endTime;

        // 기본형 long 사용

        long sumPrimitive = 0;
        startTime = System.currentTimeMillis();

        for (int i = 0; i < iterations; i++) {
            sumPrimitive += i;
        }

        endTime = System.currentTimeMillis();
        System.out.println("sumPrimitive = " + sumPrimitive);
        System.out.println("기본형 long 시간 : " + (endTime - startTime));

        // 래퍼 클래스 Long 사용
        Long sumWrapper = 0L;

        startTime = System.currentTimeMillis();

        for (int i = 0; i < iterations; i++) {
            sumWrapper += i; // 오토박싱 방생
        }

        endTime = System.currentTimeMillis();
        System.out.println("sumWrapper = " + sumWrapper);
        System.out.println("래퍼 클래스  Long 시간 : " + (endTime - startTime));


    }
}
