package helpers;

import com.github.javafaker.Faker;

/**
 * Класс генерации случайных данных
 */
public class GenerateRandomData {
     private static final Faker faker = new Faker(); //Создание экземпляра класса библиотеки Faker
     private static final String postCode = "[0-9]{10}"; //Задание типа и формы для генерации значения Post Code

     public static String getRandomPostCode(){return faker.regexify(postCode);} // Генерация значения Post Code
     public static String getNameByPostCode(String postCodeNumbers){ //Генерация значения First Name на основе числовой строки
          StringBuilder generateName = new StringBuilder();
          for (int i =0; i<postCodeNumbers.length();i+=2){
               String pair = postCodeNumbers.substring(i,i+2);
               int number = Integer.parseInt(pair);
               int index = number % 26;
               char letter = (char) ('a'+index-1);
               generateName.append(letter);
          }
          return generateName.toString();
     }

     public static String getRandomLastName(){return faker.name().lastName();} // Генерация значения Last Name

}
