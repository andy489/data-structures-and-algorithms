// https://leetcode.com/problems/split-with-minimum-sum/

class Solution {
    public int splitNum(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        Arrays.sort(digits);
        int num1 = 0, num2 = 0;
        for (int i = 0; i < digits.length; i++) {
            if (i % 2 == 0) {
                num1 = num1 * 10 + (digits[i] - '0');
            } else {
                num2 = num2 * 10 + (digits[i] - '0');
            }
        }
        return num1 + num2;
    }
}
