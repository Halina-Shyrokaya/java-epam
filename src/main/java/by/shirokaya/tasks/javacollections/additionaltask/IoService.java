package by.shirokaya.tasks.javacollections.additionaltask;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class IoService {

    private final Scanner scanner;
    private final FileWriter fileWriter;

    public IoService(File in, File out) throws IOException {
        this.scanner = new Scanner(in);
        this.fileWriter = new FileWriter(out);
    }

    public Scanner getScanner() {
        return scanner;
    }

    public FileWriter getFileWriter() {
        return fileWriter;
    }

    public Stack<String> readLinesToStack() {
        Stack<String> stack = new Stack<>();
        while (scanner.hasNextLine()) {
            stack.push(scanner.nextLine());
        }
        return stack;
    }

    public List<String> readLinesToList() {
        List<String> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            list.add(scanner.nextLine());
        }
        return list;
    }

    public void writeStackToFile(Stack<String> stack) throws IOException {
        while (!stack.isEmpty()) {
            fileWriter.write(stack.pop() + "\n");
        }
        fileWriter.flush();
    }

    public void writeCollectionToFile(Collection<String> collection) throws IOException {
        for (String line : collection) {
            fileWriter.write(line + "\n");
        }
        fileWriter.flush();
    }

    public String readFileToString() {
        StringBuilder builder = new StringBuilder();
        while (scanner.hasNextLine()) {
            builder.append(scanner.nextLine());
        }
        return builder.toString().toLowerCase();
    }

    public Set<String> splitStringIntoUniqueWords(String str) {
        return new HashSet<>(Arrays.asList(str.split("[, ?.@\\d]+")));
    }
}
