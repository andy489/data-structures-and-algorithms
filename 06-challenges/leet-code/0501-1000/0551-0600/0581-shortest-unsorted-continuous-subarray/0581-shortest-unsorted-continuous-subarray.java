// https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int left = -1, right = -1;
        int runMax = Integer.MIN_VALUE, runMin = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] < runMax) {
                right = i;
            }
            runMax = Math.max(runMax, nums[i]);
        }
        if (right == -1) {
            return 0;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > runMin) {
                left = i;
            }
            runMin = Math.min(runMin, nums[i]);
        }
        return right - left + 1;
    }
}

class Solution2 {
    public int findUnsortedSubarray(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int left = nums.length, right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != sorted[i]) {
                left = Math.min(left, i);
                right = Math.max(right, i);
            }
        }
        return right > left ? right - left + 1 : 0;
    }
}
