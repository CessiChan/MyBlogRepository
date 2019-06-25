package utils.testPojo;

public class LiSi extends HumanWithCar{
    public LiSi(Car car) {
        super(car);
    }

    public void goHome() {
        car.start();
        car.turnRight();
        car.stop();
    }
}
