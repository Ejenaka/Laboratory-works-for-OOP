package Lab1;

import java.util.Hashtable;

public class LabTasks {
            
    // Task 3
    /*
    Створіть метод, який дозволяє вставляти в будь яку позицію масиву будь яке число.
    Метод повинен повертати новий масив.
    */
    public int[] insertNumber(int[] array, int number, int index) {
        int[] newArr = new int[array.length + 1];
        for (int i = 0, j = 0; i < newArr.length; i++, j++) {
            if (i == index) {
                newArr[i] = number;
                j--;
                continue;
            }
            newArr[i] = array[j];
        }
        return newArr;
    }

    // Task 5
    /*
    Створіть метод, який дозволяє видаляти всі елементи в масиві int[] , які мають певне значення, наприклад, дорівнюють 23.
    Масив без видалених елементів повинен повертатися, як результат роботи методу.
    */
    public int[] deleteElements(int[] array, int number) {
        int numbersCount = 0;
        for (int element : array) {
            if (element == number) {
                numbersCount++;
            }
        }
        if (numbersCount == 0) {
            return array;
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
    /*
    Створіть метод, який перевертає будь яке слово. Наприклад, на вході «травень» на виході «ьневарт».
    */
    public String reverseString(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            stringBuilder.append(str.charAt(i));
        }
        return stringBuilder.toString();
    }

    // Task 8
    /*
     Створіть метод, який підраховує кількість однакових чисел у будь якому масиві int[].
     Приклад [1,7,3,9,34,3,7].
     Результат :  1 - 1 раз, 7 - 2 рази, 3 - 2 рази і т.д.
    */
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
    /*
     Створіть метод, який приймає будь-яку кількість масивів int[] та повертає найменше число яке є у складі цих масивів.
    */
    public int minValueOfArrays(int[]...array) {
        if (array.length == 0) {
            return 0;
        }
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
