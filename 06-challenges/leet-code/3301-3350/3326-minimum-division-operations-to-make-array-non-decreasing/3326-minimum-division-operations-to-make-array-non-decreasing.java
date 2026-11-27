// https://leetcode.com/problems/minimum-division-operations-to-make-array-non-decreasing/

class Solution {
    public int minOperations(int[] nums) {
        int maxVal = 1000001;
        int[] spf = new int[maxVal];
        for (int i = 0; i < maxVal; i++) {
            spf[i] = i;
        }
        for (int i = 2; (long) i * i < maxVal; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j < maxVal; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }
        int ops = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                nums[i] = spf[nums[i]];
                if (nums[i] > nums[i + 1]) {
                    return -1;
                }
                ops++;
            }
        }
        return ops;
    }
}
