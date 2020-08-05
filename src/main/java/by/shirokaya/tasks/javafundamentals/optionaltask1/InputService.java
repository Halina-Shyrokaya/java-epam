package by.shirokaya.tasks.javafundamentals.optionaltask1;

import org.apache.commons.lang3.math.NumberUtils;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class InputService {

    private final Scanner scanner;
    private final PrintStream out;

    public InputService(InputStream in, PrintStream out) {
        scanner = new Scanner(in).useLocale(Locale.US);
        this.out = out;
    }

    public String ask(String message) {
        out.println(message);
        return scanner.next();
    }

    public String getPositiveNumberAsString() {
        long result = 0;
        String input = null;
        while (result <= 0) {
            input = ask("Enter positive number: ");
            boolean isNumber = NumberUtils.isCreatable(input);
            while (!isNumber) {
                input = ask("Try again:");
                isNumber = NumberUtils.isCreatable(input);
            }
            result = NumberUtils.toLong(input);
        }
        return input;
    }

    public List<String> getListOfNumbersAsStrings(int quantityOfInputs) {
        List<String> inputs = new ArrayList<>();
        for (int i = 1; i <= quantityOfInputs; i++) {
            inputs.add(getPositiveNumberAsString());
        }
        return inputs;
    }

}
