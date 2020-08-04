package by.shirokaya.tasks.javafundamentals.greeting;

//1.     Приветствовать любого пользователя при вводе его имени через командную строку.
public class Main {
    public static void main(String[] args) {
        GreetService greetService = new GreetService(System.in, System.out);
        greetService.greet();
    }
}
