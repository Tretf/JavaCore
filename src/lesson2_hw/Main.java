package lesson2_hw;

public class Main {

    public static void main(String[] args) {

        // первый массив
        System.out.println("\nМассив № 1");
        String[][] stringArray = new String[4][4];

        for (int i = 0; i < 4; i++) {
            System.out.print("Строка " + (i + 1) + " : ");
            for (int j = 0; j < 4; j++) {
                stringArray[i][j] = String.valueOf(i) +  String.valueOf(j);
                System.out.print(stringArray[i][j] + " ; ");
            }
            System.out.println();
        }

        takeArray(stringArray);

        // второй массив
        System.out.println("\nМассив № 2");
        String[][] stringArray2 = new String[3][5];

        for (int i = 0; i < 3; i++) {
            System.out.print("Строка " + (i + 1) + " : ");
            for (int j = 0; j < 5; j++) {
                stringArray2[i][j] = String.valueOf(i) +  String.valueOf(j);
                System.out.print(stringArray2[i][j] + " ; ");
            }
            System.out.println();
        }

        takeArray(stringArray2);

        // третий массив
        System.out.println("\nМассив № 3");
        String[][] stringArray3 = new String[4][4];

        for (int i = 0; i < 4; i++) {
            System.out.print("Строка " + (i + 1) + " : ");
            for (int j = 0; j < 3; j++) {
                stringArray3[i][j] = String.valueOf(i) +  String.valueOf(j);
                System.out.print(stringArray3[i][j] + " ; ");
            }
            stringArray3[i][3] = "row" + String.valueOf(i + 1);
            System.out.print(stringArray3[i][3] + " \n");
        }

        takeArray(stringArray3);

    }

    public static void takeArray(String[][] stringArray) throws MyArraySizeException {
        int sumArray = 0;

        if (stringArray.length != 4 || stringArray[0].length != 4) {
            try {
                throw new MyArraySizeException("размер массива равен не 4 x 4 => " + stringArray.length + " x " + stringArray[0].length);
            } catch (MyArraySizeException e) {
                System.out.println("Массив не обрабатывается");
            }
        } else {
            try {
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        sumArray = sumArray + Integer.parseInt(stringArray[i][j]);
                    }
                }
                System.out.println("Сумма элементов массива = " + sumArray);

            } catch (MyArrayDataException e) {
                throw new MyArrayDataException("В массиве есть значения, которые нельзя суммировать Сумма элементов массива неизвестна");
            } catch (NumberFormatException e) {
               // e.printStackTrace();
                System.out.println("В массиве есть значения, которые нельзя суммировать. Сумма элементов массива неизвестна");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Что-то неправильно");
            } finally {
                System.out.println("расчет закончен");
            }

        }
    }
}
