package Lab1;

import java.util.Hashtable;

public class Main {

    public static void main(String[] args) {
        LabTasks tasks = new LabTasks();

        // Task 3
        int[] arrayTask1 = {1,2,3,4,5,6};
        int[] newArrayTask1 = tasks.insertNumber(arrayTask1, 1, 1);
        tasks.printArray(newArrayTask1);
        System.out.println();

        // Task 5
        int[] arrayTask2 = {1, 1, 0, 5, 6, 8};
        int[] newArrayTask2 = tasks.deleteElements(arrayTask2, 1);
        tasks.printArray(newArrayTask2);
        System.out.println();

        // Task 19
        String str = tasks.reverseString("травень");
        System.out.println(str);

        // Task 8
        Hashtable<Integer, Integer> numsInfo = tasks.getNumbersInfo(new int[]{1,7,3,9,34,3,7});
        numsInfo.forEach((num, count) -> System.out.println(num + ": " + count));

        // Task 29
        int minValue = tasks.minValueOfArrays(new int[]{1,2,3,3,4}, new int[]{1,-1,2,3,4});
        System.out.println(minValue);

    }
}