package by.shirokaya.tasks.javafundamentals.monthapp;

//12. Вывести на консоль название месяца, соответствующего данному числу. Осуществить проверку корректности ввода чисел.
public class Main {
    public static void main(String[] args) {
        MonthMatchingService service = new MonthMatchingService();
        service.print(Language.RUSSIAN);
        service.print();
    }
}
