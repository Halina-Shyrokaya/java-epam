package by.shirokaya.tasks.javacollections.additionaltask;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Runner {

    public static void main(String[] args) {
        File origin = new File("./src/main/java/by/shirokaya/tasks/javacollections/files/origin.txt");
        File reversed = new File("./src/main/java/by/shirokaya/tasks/javacollections/files/reversed.txt");
        File sortedByLength = new File("./src/main/java/by/shirokaya/tasks/javacollections/files/sortedByLength.txt");
        File sortedAlphabetically = new File("./src/main/java/by/shirokaya/tasks/javacollections/files/sortedAlphabetically.txt");
        File englishText = new File("./src/main/java/by/shirokaya/tasks/javacollections/files/englishText.txt");
        File setOfWords = new File("./src/main/java/by/shirokaya/tasks/javacollections/files/setOfWords.txt");

        IoService ioService;

        //1.   Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.
        try {
            ioService = new IoService(origin, reversed);
            Stack<String> stack = ioService.readLinesToStack();
            ioService.writeStackToFile(stack);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //4.   Занести стихотворение в список. Провести сортировку по возрастанию длин строк.
        try {
            ioService = new IoService(origin, sortedByLength);
            List<String> list = ioService.readLinesToList();
            list.sort(Comparator.comparing(String::length));
            ioService.writeCollectionToFile(list);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //6. Ввести строки из файла, записать в список ArrayList.
        // Выполнить сортировку строк, используя метод sort() из класса Collections.
        try {
            ioService = new IoService(origin, sortedAlphabetically);
            List<String> list = ioService.readLinesToList();
            Collections.sort(list);
            ioService.writeCollectionToFile(list);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //8. Задан файл с текстом на английском языке. Выделить все различные слова.
        //Слова, отличающиеся только регистром букв, считать одинаковыми. Использовать класс HashSet.
        try {
            ioService = new IoService(englishText, setOfWords);
            String str = ioService.readFileToString();
            Set<String> set = ioService.splitStringIntoUniqueWords(str);
            ioService.writeCollectionToFile(set);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //2. Ввести число, занести его цифры в стек. Вывести число, у которого цифры идут в обратном порядке.
        System.out.println(NumberAction.reverseNumber(45649713));

    }

}

