package lang.object.poly;

public class ObjectPolyExample1 {
    public static void main(String[] args) {

        Dog dog = new Dog();
        Car car = new Car();

        action(dog);
        action(car);
    }

    private static void action(Object obj) {
//        Object는  밑에 메서드 가지고 있지 않음
//        obj.sound();
//        obj.move();

        // 객체에 맞는 다운캐스팅 필요
        if (obj instanceof Dog dog) {
            dog.sound();
        } else if (obj instanceof Car car) {
            car.move();
        }

    }

}
