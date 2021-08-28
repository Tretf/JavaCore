package lesson1_hw;

public class Main {

    public static void main(String[] args) {
        double distance = 100;
        double playerTime;
        double allTime = 0;

        System.out.println("\n === Полоса препятствий ===\n");
        System.out.println("Длина дистанции " + String.format("%.0f",distance) + " м\n");

        Course course = new Course();

        distance = distance / (course.countObstacle + 1);
        System.out.println();
        System.out.println("Количество препятствий " + course.countObstacle);
        System.out.println("Длина этапа дистанции " + String.format("%.2f",distance) + " м");

//        Player player1 = new Player("First", 70, 100);
//        Player player2 = new Player("Second", 60, 80);
//        Player player3 = new Player("Third", 90, 75);
//        Player player4 = new Player("Fourth", 85, 92);

        Player[] team = new Player[4];
        team[0] = new Player("Ваня", 70, 100);
        team[1] = new Player("Петя", 60, 80);
        team[2] = new Player("Миша", 90, 75);
        team[3] = new Player("Саша", 85, 92);

        for (int i = 0; i < team.length; i++) {
            playerTime = 0;
            System.out.println();
//            System.out.println("\nИгрок " + team[i].name);
            team[i].playerInfo();
            for (int j = 0; j <= course.countObstacle-1; j++) {
                System.out.println("Этап " + (j + 1));
                team[i].losePower(course.powerObstacle[j]);
                team[i].playerInfo();
                playerTime = playerTime + team[i].completeDistance(distance);
                allTime = allTime + team[i].completeDistance(distance);

            }
            System.out.println("Этап " + (course.countObstacle + 1));
            playerTime = playerTime + team[i].completeDistance(distance);
            allTime = allTime + team[i].completeDistance(distance);
            System.out.println("Игрок прошел дистанцию за  " + String.format("%.2f", playerTime) + " минуты");

        }

        System.out.println("\nОбщее время команды " + String.format("%.2f", allTime) + " минут");

    }

}
