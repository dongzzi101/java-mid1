package lang.wrapper;

public class AutoBoxingMain1 {

    public static void main(String[] args) {
        // primitive -> wrapper
        int value = 5;
        Integer boxedValue = Integer.valueOf(value);

        // wrapper -> primitive
        int unboxedValue = boxedValue.intValue();

        System.out.println("boxedValue = " + boxedValue);
        System.out.println("unboxedValue = " + unboxedValue);
    }
}
