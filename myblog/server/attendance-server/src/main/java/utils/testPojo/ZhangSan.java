package utils.testPojo;

public class ZhangSan extends HumanWithCar {
    public ZhangSan(Car car) {
        super(car);
    }

    public void goHome() {
        car.start();
        car.turnLeft();
        car.turnRight();
        car.stop();
    }
}
