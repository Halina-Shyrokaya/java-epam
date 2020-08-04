package by.shirokaya.tasks.javafundamentals.monthapp;

import java.util.Scanner;

public class MonthMatchingService {

    public void print() {
        print(Language.ENGLISH);
    }

    public void print(Language language) {
        while (true) {
            System.out.println("Enter number (1-12): ");
            String input = new Scanner(System.in).nextLine().trim();
            if (language.getMatching().containsKey(input)) {
                System.out.println(language.getMatching().get(input));
                break;
            } else {
                System.out.println("Try again.");
            }
        }
    }
}
