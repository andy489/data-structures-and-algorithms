// https://leetcode.com/problems/closest-subsequence-sum/

// Solution: Meet in the Middle — O(2^(n/2)·n) time, O(2^(n/2)) space
class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        int half = n / 2;
        int leftSize = 1 << half;
        int rightSize = 1 << (n - half);

        int[] leftSums = new int[leftSize];
        for (int mask = 0; mask < leftSize; mask++) {
            int s = 0;
            for (int i = 0; i < half; i++) {
                if ((mask >> i & 1) == 1) {
                    s += nums[i];
                }
            }
            leftSums[mask] = s;
        }

        int[] rightSums = new int[rightSize];
        for (int mask = 0; mask < rightSize; mask++) {
            int s = 0;
            for (int i = 0; i < n - half; i++) {
                if ((mask >> i & 1) == 1) {
                    s += nums[half + i];
                }
            }
            rightSums[mask] = s;
        }

        Arrays.sort(rightSums);
        int ans = Integer.MAX_VALUE;
        for (int ls : leftSums) {
            int target = goal - ls;
            int idx = Arrays.binarySearch(rightSums, target);
            if (idx >= 0) {
                return 0;
            }
            idx = -(idx + 1);
            if (idx < rightSize) {
                ans = Math.min(ans, Math.abs(ls + rightSums[idx] - goal));
            }
            if (idx > 0) {
                ans = Math.min(ans, Math.abs(ls + rightSums[idx - 1] - goal));
            }
        }
        return ans;
    }
}
