package lesson3_hw;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // задание 1 Написать метод, который меняет два элемента массива местами (массив может быть любого
        //ссылочного типа);

        System.out.println("Задание 1");
        int[] arrOne = {1, 2, 3, 4, 5, 6};
        int tempOne;

        System.out.print("Массив прямой {" + arrOne[0]);
        for (int i = 1; i < arrOne.length; i++){
            System.out.print(", " + arrOne[i]);
        }
        System.out.println("}");

        for (int i = 0; i < arrOne.length/2; i++) {
            tempOne = arrOne[arrOne.length - i - 1];
            arrOne[arrOne.length - i - 1] = arrOne[i];
            arrOne[i] = tempOne;
        }

        System.out.print("Массив обратный {" + arrOne[0]);
        for (int i = 1; i < arrOne.length; i++){
            System.out.print(", " + arrOne[i]);
        }
        System.out.print("}");
        System.out.println();


        // задание 2
        System.out.println("\nЗадание 2");

        Apple apple1 = new Apple((float) 0.99);
        Apple apple2 = new Apple((float) 1.00);
        Apple apple3 = new Apple((float) 1.01);
        Apple apple4 = new Apple((float) 1.02);

        Box box1_apple = new Box();

        ArrayList<Apple> boxApple = new ArrayList<Apple>();
//       boxApple.add(new Apple(apple1));
        boxApple.add(apple1);
        boxApple.add(apple2);
        boxApple.add(apple3);
        boxApple.add(apple4);

        box1_apple.setBox(boxApple);

        float weightBox1 = box1_apple.getWeight(boxApple);

        System.out.println("Вес первой коробки яблок = " + weightBox1);



        Orange orange1 = new Orange((float) 1.50);
        Orange orange2 = new Orange((float) 1.51);
        Orange orange3 = new Orange((float) 1.52);
        Orange orange4 = new Orange((float) 1.53);

        Box box1_orange = new Box();

        ArrayList<Orange> boxOrange1 = new ArrayList<Orange>();
        boxOrange1.add(orange1);
        boxOrange1.add(orange2);
        boxOrange1.add(orange3);
        boxOrange1.add(orange4);

        box1_orange.setBox(boxOrange1);

        float weightBox2 = box1_orange.getWeight(boxOrange1);

        System.out.println("Вес первой коробки апельсин = " + String.format("%.2f", weightBox2));


        Orange orange5 = new Orange(1.50f);
        Orange orange6 = new Orange( 1.51f);
        Orange orange7 = new Orange( 1.52f);
        Orange orange8 = new Orange( 1.53f);

        Box box2_orange = new Box();

        ArrayList<Orange> boxOrange2 = new ArrayList<Orange>();
        boxOrange2.add(orange5);
        boxOrange2.add(orange6);
        boxOrange2.add(orange7);
        boxOrange2.add(orange8);

        box2_orange.setBox(boxOrange2);

        float weightBox3 = box2_orange.getWeight(boxOrange2);

        System.out.println("Вес второй коробки апельсин = " + String.format("%.2f", weightBox3));

        String true_false;

        if (box1_orange.compare(box2_orange)){
            true_false = "равны";
        } else {
            true_false = "не равны";
        }

        System.out.println("Первая и вторая коробка апельсин " + true_false);

        if (box1_orange.compare(box1_apple)){
            true_false = "равны";
        } else {
            true_false = "не равны";
        }

        System.out.println("Первая коробка апельсин и коробка яблок " + true_false);


        // пересыпаем
        Box box2_apple = new Box();
        ArrayList<Apple> boxApple2 = new ArrayList<Apple>();
        box2_apple.setBox(boxApple2);

        box1_apple.changeBox(box2_apple);

        ArrayList<Apple> boxApple3 = new ArrayList<Apple>();
        box1_apple.setBox(boxApple3);

        float weightBox4 = box2_apple.getWeight(boxApple2);

        System.out.println("Вес второй коробки яблок = " + weightBox4);
        weightBox4 = box1_apple.getWeight(boxApple3);
        System.out.println("Вес первой коробки яблок = " + weightBox4);
    }

}
