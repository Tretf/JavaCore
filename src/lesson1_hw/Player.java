package lesson1_hw;

import javax.xml.namespace.QName;

public class Player {

//    public String name;
//    public double speed;
//    public double power;

    private String name;
    private double speed;
    private double power;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }


    public Player(String name, int speed, int power){
        this.name = name;
        this.speed = speed;
        this.power = power;
    }

    public double completeDistance(double distance) {
        return distance / speed;
    }

    public void losePower(int powerCourse) {
        speed = (power - powerCourse)/power*speed;
        power = power - powerCourse;
    }

    public void playerInfo() {
        System.out.println("Игрок " + name + ": сила " + power + ", скорость " + String.format("%.2f", speed) + " м/мин");
    }
}
