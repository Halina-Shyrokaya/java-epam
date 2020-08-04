package by.shirokaya.tasks.javafundamentals.randomnums;

import java.util.ArrayList;
import java.util.List;

public class RandomGenerator {
    private final InputService inputService;

    public RandomGenerator(InputService inputService) {
        this.inputService = inputService;
    }

    public List<Double> generateRandomNumbers() {
        int quantity = inputService.getPositiveIntegerFromConsole();
        List<Double> list = new ArrayList<>();
        for (int i = 1; i <= quantity; i++) {
            list.add(Math.random());
        }
        return list;
    }

    public void printRandomNumbers(List<Double> list, boolean hasNewLineForEachNumber) {
        for (Double number : list) {
            if (hasNewLineForEachNumber) {
                System.out.println(number);
            } else {
                System.out.print(number + " ");
            }
        }
    }
}

