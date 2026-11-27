// https://leetcode.com/problems/minimum-moves-to-make-array-complementary/

// Solution: Difference Array — O(n + limit) time, O(limit) space
class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] diff = new int[2 * limit + 2];
        for (int i = 0; i < n / 2; i++) {
            int a = Math.min(nums[i], nums[n - 1 - i]);
            int b = Math.max(nums[i], nums[n - 1 - i]);
            int sum = nums[i] + nums[n - 1 - i];
            // Range [2, a+1): cost 2 -> we need -1 at start of range where cost becomes 1
            // [2, a]: cost 2
            // [a+1, sum-1]: cost 1
            // [sum]: cost 0
            // [sum+1, b+limit]: cost 1
            // [b+limit+1, 2*limit]: cost 2
            diff[2]        += 2;
            diff[2 * limit + 1] -= 2;
            // subtract 1 at [a+1, 2*limit]
            diff[a + 1]    -= 1;
            diff[2 * limit + 1] += 1;
            // subtract 1 at [sum, sum] (another -1 makes cost 0)
            diff[sum]      -= 1;
            diff[sum + 1]  += 1;
            // add 1 at [b + limit + 1, 2*limit]
            diff[b + limit + 1] += 1;
            diff[2 * limit + 1] -= 1;
        }
        int minMoves = Integer.MAX_VALUE;
        int cur = 0;
        for (int t = 2; t <= 2 * limit; t++) {
            cur += diff[t];
            minMoves = Math.min(minMoves, cur);
        }
        return minMoves;
    }
}
