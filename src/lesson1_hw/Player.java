package lesson1_hw;

import javax.xml.namespace.QName;

public class Player {

    public String name;
    public double speed;
    public double power;

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
