package lesson7_hw;

import java.io.IOException;
import java.util.Scanner;

public class UserInterfaceView {
    private Controller controller = new Controller();

    public void runInterface() {
        Scanner scanner = new Scanner(System.in);
        String option;

        while (true) {

            System.out.println("Введите 1 для прогноза на день, 5  для прогноза на 5 дней, 0 для выхода: ");

            while (true) {
                option = scanner.nextLine();
                if (!option.equals("0") & !option.equals("1") & !option.equals("5")) {
                    System.out.println("Неправильный ввод. Введите 0, 1 или 5");
                } else {
                    break;
                }
            }

            if (option.equals("0")) {
                break;
            }

            System.out.println("Введите город: ");
            String city = scanner.nextLine();


            try {
                controller.getWeather(option, city);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
