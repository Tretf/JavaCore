package lesson1_hw;

public class Course {

    public int countObstacle;
    public int[] powerObstacle;

    public Course() {
        countObstacle = 1 + (int)(Math.random() * 4);
        powerObstacle = new int[countObstacle];

        for (int i = 0; i < countObstacle ; i++) {
            powerObstacle[i] = 1 + (int)(Math.random() * 24);
            System.out.println("Трудность препятствия №  " + (i +1) + " = " + powerObstacle[i]);
        }

    }

}
