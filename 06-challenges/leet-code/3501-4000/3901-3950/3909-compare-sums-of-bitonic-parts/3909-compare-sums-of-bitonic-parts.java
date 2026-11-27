// https://leetcode.com/problems/compare-sums-of-bitonic-parts/
class Solution {
    public int compareSums(int[] nums) {
        int n = nums.length;
        int peak = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                peak = i;
                break;
            }
            peak = i + 1;
        }
        long ascSum = 0;
        for (int i = 0; i <= peak; i++) {
            ascSum += nums[i];
        }
        long descSum = 0;
        for (int i = peak; i < n; i++) {
            descSum += nums[i];
        }
        if (ascSum > descSum) {
            return 0;
        } else if (descSum > ascSum) {
            return 1;
        } else {
            return -1;
        }
    }
}
