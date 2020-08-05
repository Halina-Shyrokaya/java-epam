package by.shirokaya.tasks.javafundamentals.optionaltask1;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class NumberService {

    private final List<String> inputs;

    public NumberService(List<String> inputs) {
        this.inputs = inputs;
    }

    public void printAllLongest() {
        int maxLength = findMaxLength();
        List<String> result = findAllByLength(maxLength);
        result.forEach(input -> System.out.println("Число максимальной длины: " + input + ". Количество цифр в нем: " + input.length()));
    }

    private int findMaxLength() {
        return inputs.stream()
                .mapToInt(String::length)
                .max().orElse(-1);
    }

    public void printAllShortest() {
        int minLength = findMinLength();
        List<String> result = findAllByLength(minLength);
        result.forEach(input -> System.out.println("Число минимальной длины: " + input + ". Количество цифр в нем: " + input.length()));

    }

    private int findMinLength() {
        return inputs.stream()
                .mapToInt(String::length)
                .min().orElse(-1);
    }

    private List<String> findAllByLength(int length) {
        return inputs.stream()
                .filter(s -> s.length() == length)
                .collect(toList());
    }

    public void sortByLengthAsc() {
        List<String> result = inputs.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(toList());

        System.out.println("Числа отсортированы по возрастанию длины: ");
        System.out.println(result);
    }

    public void sortByLengthDesc() {
        List<String> result = inputs.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .collect(toList());

        System.out.println("Числа отсортированы по убыванию длины: ");
        System.out.println(result);
    }

    private double findAverageLength() {
        return inputs.stream()
                .mapToInt(String::length)
                .average().orElse(-1);
    }

    private List<String> findAllUpAverage(double avgLength) {
        return inputs.stream()
                .filter(s -> s.length() > avgLength)
                .collect(toList());
    }

    private List<String> findAllUnderAverage(double avgLength) {
        return inputs.stream()
                .filter(s -> s.length() < avgLength)
                .collect(toList());
    }

    public void printAllUpAverage() {
        double avgLength = findAverageLength();
        List<String> result = findAllUpAverage(avgLength);
        result.forEach(input -> System.out.println("Число c длиной больше среднего: " + input + ". Количество цифр в нем: " + input.length()));
    }

    public void printAllUnderAverage() {
        double avgLength = findAverageLength();
        List<String> result = findAllUnderAverage(avgLength);
        result.forEach(input -> System.out.println("Число c длиной меньше среднего: " + input + ". Количество цифр в нем: " + input.length()));
    }

    private Set<Character> convertToCharSet(String input) {
        return input.chars().mapToObj(c -> (char) c).collect(toSet());
    }

    private List<Integer> convertToIntList(String input) {
        List<Character> list = input.chars().mapToObj(c -> (char) c).collect(toList());
        List<Integer> result = new ArrayList<>();
        for (Character c : list) {
            result.add(NumberUtils.toInt(String.valueOf(c)));
        }
        return result;
    }

    private long findQtyOfEvenDigits(String input) {
        List<Integer> list = convertToIntList(input);
        return list.stream()
                .filter(s -> s % 2 == 0)
                .count();
    }

    private long findQtyOfUnEvenDigits(String input) {
        List<Integer> list = convertToIntList(input);
        return list.stream()
                .filter(s -> s % 2 == 1)
                .count();
    }

    public void compareQtyOfEvenAndUnEvenDigits() {
        for (String input : inputs) {
            int even = (int) findQtyOfEvenDigits(input);
            int uneven = (int) findQtyOfUnEvenDigits(input);
            if (uneven == 0) {
                System.out.println("В данном числе только четные цифры: " + input);
            }
            if (even == uneven) {
                System.out.println("В данном числе количество четных и нечетных чисел равны: " + input);
            }
        }
    }

    private List<Integer> sortDigitsAsc(List<Integer> origin) {
        return origin.stream()
                .sorted(Integer::compareTo)
                .collect(toList());
    }

    private boolean isOriginOrderEqualToSortedOrder(List<Integer> origin) {
        List<Integer> sorted = sortDigitsAsc(origin);
        return sorted.equals(origin) && hasAllDigitsDifferent(origin);
    }

    private boolean hasAllDigitsDifferent(List<Integer> origin) {
        List<Integer> distinct = origin.stream()
                .distinct()
                .collect(toList());
        return distinct.equals(origin);
    }

    public void printAnyWithAscOrderOfDigits() {
        for (String input : inputs) {
            boolean hasAscOrder = isOriginOrderEqualToSortedOrder(convertToIntList(input));
            if (hasAscOrder) {
                System.out.println("В этом числе цифры идут строго по возрастанию: " + input);
                break;
            }
        }
    }

    public void printAnyWithAllDigitsDifferent() {
        for (String input : inputs) {
            boolean hasAllDigitsDifferent = hasAllDigitsDifferent(convertToIntList(input));
            if (hasAllDigitsDifferent) {
                System.out.println("В этом числе все цифры различные: " + input);
                break;
            }
        }
    }

    private int findMinQtyOfDifferentDigits() {
        return inputs.stream()
                .mapToInt(input -> convertToCharSet(input).size())
                .min().orElse(-1);
    }

    public void printAnyWithMinQtyOfDifferentDigits() {
        int minQty = findMinQtyOfDifferentDigits();
        String result = inputs.stream()
                .filter(input -> convertToCharSet(input).size() == minQty)
                .findFirst()
                .get();
        System.out.println("Количество различных цифр минимально в числе: " + result);
    }

}
