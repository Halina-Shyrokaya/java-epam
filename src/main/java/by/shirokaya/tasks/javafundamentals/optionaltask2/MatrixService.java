package by.shirokaya.tasks.javafundamentals.optionaltask2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MatrixService {
    private final int[][] matrix;

    public MatrixService(int[][] matrix) {
        this.matrix = matrix;
    }

    public int[][] fillMatrixWithRandomNumbers() {
        for (int i = 0; i < matrix.length; i++) {
            for (int k = 0; k < matrix[0].length; k++) {
                matrix[i][k] = (int) (Math.random() * 99) - 50;
            }
        }
        return matrix;
    }

    public void printResultMatrix(int[][] result) {
        for (int[] line : result) {
            for (int value : line) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }

    public int[][] sortMatrix(int numOfColumn) throws NonValidNumberOfLineException {
        if (numOfColumn >= matrix[0].length || numOfColumn < 0) {
            throw new NonValidNumberOfLineException("Некорректный ввод номера столбца матрицы. Номер должен быть от 0 до " + (matrix[0].length - 1));
        }

        int[] tempLine;
        boolean isChanged = true;
        while (isChanged) {
            isChanged = false;
            for (int i = 0; i < matrix.length - 1; i++) {
                if (matrix[i][numOfColumn] > matrix[i + 1][numOfColumn]) {
                    tempLine = matrix[i];
                    matrix[i] = matrix[i + 1];
                    matrix[i + 1] = tempLine;
                    isChanged = true;
                }
            }
        }
        System.out.println();
        printResultMatrix(matrix);
        return matrix;
    }

    public List<List<Integer>> getSummaryOfQueuesAsc() {
        List<Integer> queue = new ArrayList<>();
        List<List<Integer>> summary = new ArrayList<>();

        for (int[] ints : matrix) {
            for (int k = 0; k < matrix[0].length - 1; k++) {
                if (queue.isEmpty() && ints[k] < ints[k + 1]) {
                    queue.add(ints[k]);
                    queue.add(ints[k + 1]);
                } else if (ints[k] < ints[k + 1]) {
                    queue.add(ints[k + 1]);
                } else if (!queue.isEmpty()) {
                    saveQueue(queue, summary);
                }
                if (!queue.isEmpty() && k == matrix[0].length - 2) {
                    saveQueue(queue, summary);
                }
            }
        }
        return summary;
    }

    private void saveQueue(List<Integer> queue, List<List<Integer>> summary) {
        summary.add(new ArrayList<>(queue));
        queue.clear();
    }

    public void findLongestQueue(List<List<Integer>> summary) {
        int max = summary.stream().mapToInt(List::size).max().orElse(-1);
        List<List<Integer>> maxSummary = summary.stream()
                .filter(list -> list.size() == max)
                .collect(Collectors.toList());
        for (List<Integer> list : maxSummary) {
            System.out.println("Максимальная цепочка чисел по возрастанию: " + Arrays.toString(list.toArray()));
        }
    }

    public List<Object> findSum() {
        List<Object> sumByLine = new ArrayList<>();
        List<Integer> indexes;

        for (int[] ints : matrix) {
            indexes = getIndexesOfTwoFirstPositives(ints);
            Integer temp = 0;
            System.out.println(Arrays.toString(indexes.toArray()));
            if (indexes.size() <= 1) {
                temp = null;
            } else if ((indexes.get(1) - indexes.get(0)) == 1) {
                temp = null;
            } else {
                for (int j = indexes.get(0) + 1; j < indexes.get(1); j++) {
                    temp += ints[j];
                }
            }
            sumByLine.add(temp);
        }
        return sumByLine;
    }

    public void printSumByLine(List<Object> sumByLine) {
        for (int i = 0; i < sumByLine.size(); i++) {
            if (sumByLine.get(i) == null) {
                System.out.println("В строке " + i + " элементов, расположенных между первым" +
                        " и вторым положительными элементами, не существует");
            } else {
                System.out.println("В строке " + i + " сумма элементов матрицы, расположенных между первым" +
                        " и вторым положительными элементами, равна: " + sumByLine.get(i));
            }

        }
    }

    private List<Integer> getIndexesOfTwoFirstPositives(int[] ints) {

        List<Integer> list = getArrayAsList(ints);
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (result.size() == 2) {
                break;
            }
            if (list.get(i) > 0) {
                result.add(i);
            }
        }
        return result;
    }

    private List<Integer> getArrayAsList(int[] ints) {
        List<Integer> list = new ArrayList<>();
        for (Integer i : ints) {
            list.add(i);
        }
        return list;
    }

    private List<Integer> matrixToList() {
        List<Integer> result = new ArrayList<>();
        for (int[] line : matrix) {
            for (int value : line) {
                result.add(value);
            }
        }
        return result;
    }

    private Integer findMaxValue(List<Integer> list) {
        return Objects.requireNonNull(list.stream().max(Integer::compareTo).orElse(null));
    }

    private int getCountOfMaxValue(List<Integer> list, Integer max) {
        return (int) list.stream().filter(i -> i.equals(max)).count();
    }

    public void deleteRowsAndColumnsWithMaxValue() {
        int max = findMaxValue(matrixToList());
        System.out.println("Максимальное число в матрице: " + max);
        int count = getCountOfMaxValue(matrixToList(), max);
        System.out.println("Число вхождений максимального числа: " + count);
        int row = 0;
        int column = 0;
        int newRow = matrix.length - 1;
        int newColumn = matrix[0].length - 1;
        int[][] result = new int[0][];

        while (count > 0) {
            result = new int[newRow][newColumn];

            for (int i = 0; i < matrix.length; i++) {
                for (int k = 0; k < matrix[0].length; k++) {
                    if (matrix[i][k] == max) {
                        row = i;
                        column = k;
                    }
                }
            }

            for (int i = 0; i < newRow; i++) {
                for (int k = 0; k < newColumn; k++) {
                    if ((i < row) && (k < column)) {
                        result[i][k] = matrix[i][k];
                    }
                    if ((i < row) && (k >= column)) {
                        result[i][k] = matrix[i][k + 1];
                    }
                    if ((i >= row) && (k < column)) {
                        result[i][k] = matrix[i + 1][k];
                    }
                    if ((i >= row) && (k >= column)) {
                        result[i][k] = matrix[i + 1][k + 1];
                    }
                }
            }

            count--;
            newRow--;
            newColumn--;

        }
        System.out.println("Матрица без строк и столбцов, содержащих максимальный элемент: ");
        printResultMatrix(result);
    }
}




