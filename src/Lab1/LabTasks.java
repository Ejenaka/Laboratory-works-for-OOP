package Lab1;

import java.util.Hashtable;

public class LabTasks {
            
    // Task 3
    public int[] insertNumber(int[] array, int number, int index) {
        int[] newArr;
        if (index > array.length - 1) {
            newArr = new int[index + 1];
        } else {
            newArr = new int[array.length];
        }
        for (int i = 0; i < array.length; i++) {
            newArr[i] = array[i];
        }
        newArr[index] = number;
        return newArr;
    }

    // Task 5
    public int[] deleteElements(int[] array, int number) {
        int numbersCount = 0;
        for (int element : array) {
            if (element == number) {
                numbersCount++;
            }
        }
        int[] newArr = new int[array.length - numbersCount];
        for (int i = 0, j = 0; i < array.length; i++) {
            if (array[i] != number) {
                newArr[j] = array[i];
                j++;
            }
        }
        return newArr;
    }

    // Task 19
    public String reverseString(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }

    // Task 8
    public Hashtable<Integer, Integer> getNumbersInfo(int[] array) {
        Hashtable<Integer, Integer> numbersInfo = new Hashtable<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {
            int numbersCount = 0;
            for (int j = i; j < array.length; j++) {
                if (array[i] == array[j]) {
                    numbersCount++;

                }
            }
            if (!numbersInfo.containsKey(array[i])) {
                numbersInfo.put(array[i], numbersCount);
            }
        }
        return numbersInfo;
    }

    // Task 29
    public int minValueOfArrays(int[]...array) {
        int minValue = array[0][0];
        for (int[] tmp : array) {
            for (int number: tmp) {
                if (minValue > number) {
                    minValue = number;
                }
            }
        }
        return minValue;
    }

    public void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
