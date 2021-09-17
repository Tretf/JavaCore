package lesson1;


public class Turtle extends Animal  implements CanSwim{

    private int swimmingSpeed;

    public Turtle(String name, String color, int age) {
        super(name, color, age);
    }

    @Override
    public void voice() {
        System.out.println("Черепаха молчит");
    }

    public double swim(Pool pool) {
        System.out.println("Черепаха проплывает бассейн за " + pool.getLength() / swimmingSpeed);
        return  pool.getLength() / swimmingSpeed;
    }
}
