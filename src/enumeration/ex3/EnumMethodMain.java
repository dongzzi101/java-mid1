package enumeration.ex3;

import java.util.Arrays;

public class EnumMethodMain {

    public static void main(String[] args) {
        // 모든 enum 반환
        Grade[] grades = Grade.values();
        System.out.println("Arrays.toString(grades) = " + Arrays.toString(grades));

        for (Grade grade : grades) {
            System.out.println("name = " + grade.name() + ", ordinal = " + grade.ordinal());
        }

        // String -> ENUM 변환, 잘못된 문자면 IllegalArgumentException
        String input = "GOLD";
        Grade gold = Grade.valueOf(input);
        System.out.println("gold = " + gold); // toString() 오버라이딩 되어있음 

    }
}
