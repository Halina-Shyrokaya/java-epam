package by.shirokaya.tasks.javafundamentals.greeting;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

public class GreetService {

    private final Scanner scanner;
    private final PrintStream out;

    public GreetService(InputStream in, PrintStream out) {
        scanner = new Scanner(in).useLocale(Locale.US);
        this.out = out;
    }

    public String ask(String message){
        out.println(message);
        return scanner.next();
    }

    public void greet() {
        String name = ask("Your name: ");
        out.println("Hello, " + name);
    }
}
