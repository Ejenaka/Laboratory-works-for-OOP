package LabPracts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

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

    public int[] getMissingNumbers(int[] nums) {
        Arrays.sort(nums);
        //ArrayList<Integer> resultNumbers = new ArrayList<>();
        int min = nums[0];
        int max = nums[nums.length - 1];
        int[] range = IntStream.range(min, max).toArray();
        //System.out.println(Arrays.toString(range));
        return Arrays.stream(range).filter(num -> !isPresentInArray(nums, num)).toArray();
    }

    private boolean isPresentInArray(int[] array, int num) {
        for (int tmp : array) {
            if (num == tmp) {
                return true;
            }
        }
        return false;
    }


}
