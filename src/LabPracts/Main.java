package LabPracts;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        PractsFunctions functions = new PractsFunctions();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[][] result = functions.getPairsBySum(nums, 9);
        System.out.println(Arrays.deepToString(result));

        int[] array = {6,9,18,1};
        int[] res = functions.getMissingNumbers(array);
        System.out.println(Arrays.toString(res));
    }
}
