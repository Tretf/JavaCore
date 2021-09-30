package lesson5_hw;

import jdk.internal.access.JavaIOFileDescriptorAccess;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import static java.nio.charset.StandardCharsets.*;

public class Main {

     public static void main(String[] args) throws IOException {

        String[] arr = {"Фамилия", "Должность", "Номер телефона"};
        AppData appData = new AppData(arr);
        String[][] arr2 = {{"Иванов", "Директор", "123456"}, {"Петров", "Менеджер", "456789"}, {"Сидоров", "Водитель", "321654"}};
        appData.setData(arr2);


        File fileCsv = new File("./src/lesson5_hw/file_csv.csv");
        if (!fileCsv.exists()) {
            fileCsv.createNewFile();
        }



        // вариант 1
        System.out.println("Вариант 1");
        try (ObjectOutputStream objOut = new ObjectOutputStream(new
                 FileOutputStream(fileCsv))) {


            objOut.writeObject(appData);

        } catch (IOException e) {
            e.printStackTrace();
        }

         appData.setHeader(null);
         appData.setData(null);


         try (ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(fileCsv))){
             appData = (AppData) objIn.readObject();

             for (int i = 0; i < appData.getHeader().length; i++) {
                 System.out.print(appData.getHeader()[i] + " ");

             }
             System.out.println();

             for (int i = 0; i < appData.getData().length; i++) {
                 for (int j = 0; j < appData.getData()[0].length; j++) {
                     System.out.print(appData.getData()[i][j] + " ");
                 }
                 System.out.println();
             }

         } catch (IOException e) {
             e.printStackTrace();
         } catch (ClassNotFoundException e) {
             e.printStackTrace();
         }



         // вариант 2

         System.out.println("\nВариант 2");
         AppData2 appData2 = new AppData2(arr);
         appData2.setData(arr2);

         try (OutputStream outputStream =  new BufferedOutputStream(new FileOutputStream(fileCsv))) {

             outputStream.write(appData2.getHeader()[0].getBytes(UTF_8));
             for (int i = 1; i < appData2.getData().length; i++) {
                 outputStream.write(59);
                 outputStream.write(appData.getHeader()[i].getBytes(UTF_8));
             }
             outputStream.write("\n".getBytes(UTF_8));

             for (int i = 0; i < appData2.getData().length; i++) {
                 outputStream.write(appData2.getData()[i][0].getBytes(UTF_8));
                 for (int j = 1; j < appData2.getData()[i].length; j++) {
                     outputStream.write(59);
                     outputStream.write(appData2.getData()[i][j].getBytes(UTF_8));
                 }
                 outputStream.write("\n".getBytes(UTF_8));
             }


         } catch (IOException e) {
             e.printStackTrace();
         }

         try (InputStreamReader inputStream =  new InputStreamReader(new FileInputStream(fileCsv), UTF_8))  {

             for (int i = 0; i < (fileCsv).length() ; i++) {
                 System.out.print((char) inputStream.read());
             }
         }

     }

}
