package lesson4_hw;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        // задание 1
        System.out.println("задание 1");

        List <String> words = new ArrayList<>();

        words.add("Каждый");
        words.add("Охотник");
        words.add("Желает");
        words.add("Знать");
        words.add("Где");
        words.add("Сидит");
        words.add("Фазан");
        words.add("Каждый");
        words.add("Охотник");
        words.add("Желает");
        words.add("Знать");
        words.add("Где");
        words.add("Сидит");
        words.add("Фазан");
        words.add("Каждый");
        words.add("Охотник");
        words.add("Сидит");
        words.add("Фазан");
        words.add("Желает");
        words.add("Знать");
        words.add("Где");
        words.add("Сидит");
        words.add("Фазан");

        Map <String, Integer> uniqWords = new HashMap<>();

        words.forEach(a -> uniqWords.putIfAbsent(a, 0));

        words.forEach(a -> {
           uniqWords.compute(a, (b, c) -> c + 1);
        });

        uniqWords.forEach((a, b) -> System.out.println("Слово: " + a + ". Встречается " + b + " раза: "));


        // задание 2
        System.out.println("\nзадание 2");
        ArrayList<Phone> phones = new ArrayList<>();

        phones.add(new Phone("Иванов", "123456"));
        phones.add(new Phone("Петров", "654321"));
        phones.add(new Phone("Сидоров", "456789"));
        phones.add(new Phone("Иванов", "987654"));
        phones.add(new Phone("Максимов", "159753"));

        phones.forEach(s -> {
            if (s.getSubscriber().equals("Иванов")) {
                System.out.println("Абонент " + s.getSubscriber() + ". номер " + s.getNumber());
            }
        });

        phones.forEach(s -> {
            if (s.getSubscriber().equals("Петров")) {
                System.out.println("Абонент " + s.getSubscriber() + ". номер " + s.getNumber());
            }
        });

        phones.forEach(s -> {
            if (s.getSubscriber().equals("Максимов")) {
                System.out.println("Абонент " + s.getSubscriber() + ". номер " + s.getNumber());
            }
        });

    }
}
