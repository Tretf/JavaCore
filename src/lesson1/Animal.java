package lesson1;

public abstract class Animal {

    private String name;
    private String color;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
//        this.age = age;
        if (age < 0) {
            System.out.println("Некорректный возраст");
            this.age = 0;

        }
    }

    public Animal(String name, String color, int age){
        if (age < 0) {
            System.out.println("Некорректный возраст");
            this.age = 0;

        } else this.age = age;
        this.name = name;
        this.color = color;

    }

    public abstract void voice();
//    {
//        System.out.println("Животное изааёт звук");
//
//    }






}
