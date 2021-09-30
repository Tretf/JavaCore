package lesson1;

public class Wolf extends Animal  implements CanSwim{

    private String name;
    private String color;
    private int age;
    private int swimmingSpeed;

    /*public Wolf(String name, String color, int age){
        if (age < 0) {
            System.out.println("Некорректный возраст");
            age = 0;
            return;
        } else {
            this.age = age;
            this.name = name;
            this.color = color;
        }
    }*/

    public Wolf(String name, String color, int age){
        super(name, color, age);
    }

        @Override
    public void voice() {
        System.out.println("Волк воет");
    }

    public double swim(Pool pool) {
        System.out.println("Черепаха проплывает бассейн за " + pool.getLength() / swimmingSpeed);
        return  pool.getLength() / swimmingSpeed;
    }
}
