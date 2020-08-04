package by.shirokaya.tasks.javafundamentals.randomnums;

import org.apache.commons.lang3.math.NumberUtils;

import java.io.InputStream;
import java.io.PrintStream;
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

    public int getPositiveIntegerFromConsole() {
        int result = 0;
        while (result <= 0) {
            String input = ask("Enter positive integer: ");
            boolean isNumber = NumberUtils.isCreatable(input);
            while (!isNumber) {
                input = ask("Try again:");
                isNumber = NumberUtils.isCreatable(input);
            }
            result = NumberUtils.toInt(input);
        }
        return result;
    }

}
