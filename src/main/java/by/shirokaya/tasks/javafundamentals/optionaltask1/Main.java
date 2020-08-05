package by.shirokaya.tasks.javafundamentals.optionaltask1;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        InputService inputService = new InputService(System.in, System.out);
        List<String> inputs = inputService.getListOfNumbersAsStrings(6);
        NumberService numberService = new NumberService(inputs);
        //1.     Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.
        numberService.printAllLongest();
        numberService.printAllShortest();
        //2.     Вывести числа в порядке возрастания (убывания) значений их длины.
        numberService.sortByLengthAsc();
        numberService.sortByLengthDesc();
        //3.     Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.
        numberService.printAllUnderAverage();
        numberService.printAllUpAverage();
        //4.     Найти число, в котором количество различных цифр минимально. Если таких чисел несколько, найти первое из них.
        numberService.printAnyWithMinQtyOfDifferentDigits();
        //5.     Найти количество чисел, содержащих только четные цифры,
        // а среди оставшихся — количество чисел с равным числом четных и нечетных цифр.
        numberService.compareQtyOfEvenAndUnEvenDigits();
        //6.     Найти число, цифры в котором идут в строгом порядке возрастания. Если таких чисел несколько, найти первое из них.
        numberService.printAnyWithAscOrderOfDigits();
        //7.     Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них.
        numberService.printAnyWithAllDigitsDifferent();

    }
}
