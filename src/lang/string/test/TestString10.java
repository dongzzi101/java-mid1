package lang.string.test;

public class TestString10 {

    public static void main(String[] args) {

        String fruits = "apple,banana,mango";

        String[] splitFruits = fruits.split(",");
        for (String splitFruit : splitFruits) {
            System.out.println(splitFruit);
        }

        String joinedFruits = String.join("->", splitFruits);
        System.out.println("joinedFruits = " + joinedFruits);


    }
}
