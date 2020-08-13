package by.shirokaya.tasks.javafundamentals.optionaltask2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InputService inputService = new InputService(System.in, System.out);
        int[][] matrix = inputService.createMatrix();
        MatrixService matrixService = new MatrixService(matrix);
        matrixService.fillMatrixWithRandomNumbers();
        matrixService.printResultMatrix(matrix);
        //1.     Упорядочить строки (столбцы) матрицы в порядке возрастания значений элементов k-го столбца (строки).
        try {
            matrixService.sortMatrix(3);
        } catch (NonValidNumberOfLineException e) {
            e.printStackTrace();
        }
        //2. Найти и вывести наибольшее число возрастающих (убывающих) элементов матрицы, идущих подряд.
        List<List<Integer>> summary = matrixService.getSummaryOfQueuesAsc();
        matrixService.findLongestQueue(summary);
        //3. Найти сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки
        List<Object> sumByLine = matrixService.findSum();
        matrixService.printSumByLine(sumByLine);
        //4.Найти максимальный элемент в матрице и удалить из матрицы все строки и столбцы, его содержащие
        matrixService.deleteRowsAndColumnsWithMaxValue();

    }
}
