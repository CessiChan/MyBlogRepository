package utils.testPojo;

public class Toyota implements Car{
    private String carName="Toyota";
    public void start(){
        System.out.println(carName+" start");
    }
    public void turnLeft(){
        System.out.println(carName+" turnLeft");
    }
    public void turnRight(){
        System.out.println(carName+" turnRight");
    }
    public void stop(){
        System.out.println(carName+" stop");
    }
}
