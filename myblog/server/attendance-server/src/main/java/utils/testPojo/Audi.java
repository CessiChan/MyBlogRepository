package utils.testPojo;

public class Audi implements Car{
    private String carName="Audi";
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
