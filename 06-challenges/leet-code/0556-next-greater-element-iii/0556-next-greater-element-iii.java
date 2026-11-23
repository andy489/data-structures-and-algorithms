// https://leetcode.com/problems/next-greater-element-iii/
// Solution: Next permutation on digits — O(d) time, O(d) space
class Solution {
    public int nextGreaterElement(int n) {
        char[] digits = Integer.toString(n).toCharArray();
        int len = digits.length;
        int i = len - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }
        if (i < 0) {
            return -1;
        }
        int j = len - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }
        char tmp = digits[i];
        digits[i] = digits[j];
        digits[j] = tmp;
        int left = i + 1;
        int right = len - 1;
        while (left < right) {
            tmp = digits[left];
            digits[left] = digits[right];
            digits[right] = tmp;
            left++;
            right--;
        }
        long result = Long.parseLong(new String(digits));
        return result > Integer.MAX_VALUE ? -1 : (int) result;
    }
}
