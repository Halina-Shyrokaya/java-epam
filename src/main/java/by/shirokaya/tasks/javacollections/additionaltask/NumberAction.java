package by.shirokaya.tasks.javacollections.additionaltask;

import java.util.ArrayDeque;
import java.util.Deque;

public class NumberAction {

    public static int reverseNumber(int origin) {
        Deque<Integer> stack = new ArrayDeque<>();
        int temp = origin;
        do {
            stack.offer(temp % 10);
            temp /= 10;
        } while (temp > 0);

        StringBuilder reversed = new StringBuilder();
        for (Integer digit : stack) {
            reversed.append(digit);
        }
        return Integer.parseInt(reversed.toString());
    }
}
