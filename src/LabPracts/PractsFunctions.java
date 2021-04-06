package LabPracts;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PractsFunctions {
    public int getMaxDigitSumNumber(int[] array) {
        int maxSum = 0;
        int maxDigitSumNumber = 0;
        for (int num : array) {
            if (getDigitSum(num) > maxSum) {
                maxSum = getDigitSum(num);
                maxDigitSumNumber = num;
            }
        }
        return maxDigitSumNumber;
    }

    private int getDigitSum(int num) {
        if (num < 10 ) {
            return num;
        }
        return num % 10 + getDigitSum(num / 10);
    }

    // 4 LAB
    public Integer[][] getPairsBySum(int[] nums, int sum) {
        ArrayList<Integer[]> pairs = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++ ) {
                if (nums[i] + nums[j] == sum) {
                    pairs.add(new Integer[] {nums[i], nums[j]});
                }
            }
        }
        if (pairs.isEmpty()) {
            System.out.println("No pairs are given");
        }
        return pairs.toArray(new Integer[0][0]);
    }

}
