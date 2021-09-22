package lesson1;

public class Cat extends Animal implements CanSwim{

    private String name;
    private String color;
    private int age;
    private int swimmingSpeed;

/*    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("Некорректный возраст!");
            this.age = 0;
        }
        this.age = age;
    }

    */

    /*public Cat(String name, String color, int age){
        if (age < 0) {
            System.out.println("Некорректный возраст");
            age = 0;

        } else this.age = age;
        this.name = name;
        this.color = color;

    }*/

    public Cat(String name, String color, int age){

        super(name, color, age);

        }

public void setSwimmingSpeed(int swimmingSpeed) {
        this.swimmingSpeed = swimmingSpeed;
}

        @Override
    public String toString() {

        return "Name " + name + ", color " + color + ", age " + age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Cat cat = (Cat) obj;
        return age == cat.getAge() && name.equals(cat.getName()) && color.equals(cat.getColor());

    }

    @Override
    public void voice() {
        System.out.println("Кот мяукает");
    }

    public double swim(Pool pool) {
        System.out.println("Кот проплывает бассейн за " + pool.getLength() / swimmingSpeed);
        return  pool.getLength() / swimmingSpeed;
    }


}
