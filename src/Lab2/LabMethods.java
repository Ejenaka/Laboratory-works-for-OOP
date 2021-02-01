package Lab2;

import java.util.function.UnaryOperator;

public class LabMethods {
    public static void map(int[] array, UnaryOperator<Integer> function) {
        for (int i = 0; i < array.length; i++) {
            array[i] = function.apply(array[i]);
        }
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void printPositionInfo(Position pos) {
        System.out.println("{ " + pos.name() + ", salary: " + pos.getSalary() + " , vacation days: " + pos.getVacationDaysCount());
    }
}
