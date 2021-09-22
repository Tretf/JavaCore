package lesson1;

public class Main {

    public static void main(String[] args) {
        Cat cat1 = new Cat("Мурзик", "рыжий", 1);

        System.out.println(cat1);

        Cat cat2 = new Cat("Васька", "рыжий", 4);

        System.out.println(cat2);

//         cat2.setAge(-4) ;

        Cat cat3 = new Cat("Васька", "рыжий", 4);

        System.out.println(cat3.equals(cat2));

        cat1.voice();

        Turtle turtle1 = new Turtle("Тортила", "пятнистая", 100);
        turtle1.voice();

        Wolf wolf1 = new Wolf("Серый", "серый", 4);
        wolf1.voice();

        Animal cat4 = new Cat("Васька", "рыжий", 4);
        Animal wolf2 = new Wolf("Васька", "рыжий", 4);

        Cat cat5;

        if (wolf2 instanceof Cat) {

            cat5 = (Cat) wolf2;
            cat5.voice();
        }
            else {
            System.out.println(wolf2.getClass());}

            wolf2.voice();

        Utils.makeAnimalOlder(cat1);


    }

}
