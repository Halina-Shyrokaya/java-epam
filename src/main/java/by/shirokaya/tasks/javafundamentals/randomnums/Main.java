package by.shirokaya.tasks.javafundamentals.randomnums;

import java.util.List;

//3.     Вывести заданное количество случайных чисел с переходом и без перехода на новую строку
public class Main {
    public static void main(String[] args) {

        InputService inputService = new InputService(System.in, System.out);
        RandomGenerator randomGenerator = new RandomGenerator(inputService);
        List<Double> list = randomGenerator.generateRandomNumbers();
        randomGenerator.printRandomNumbers(list,true);
        randomGenerator.printRandomNumbers(list,false);
    }
}
