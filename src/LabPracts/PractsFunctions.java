package LabPracts;

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

    public int getDigitSum(int num) {
        if (num < 10 ) {
            return num;
        }
        return num % 10 + getDigitSum(num / 10);
    }
}
