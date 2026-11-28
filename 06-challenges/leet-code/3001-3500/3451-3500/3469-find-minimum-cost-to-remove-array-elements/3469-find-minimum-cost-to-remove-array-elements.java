// https://leetcode.com/problems/find-minimum-cost-to-remove-array-elements/

// Solution: Dynamic Programming — O(n^2) time, O(n) space
class Solution {
    private int[] nums;
    private int[][] memo;

    public int minCost(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        // dp[i][carry]: min cost to remove nums[i..n-1] with one carried element (0 means no carry)
        this.memo = new int[n + 1][1_000_001];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return solve(0, 0);
    }

    private int solve(int idx, int carry) {
        int n = nums.length;
        if (idx == n && carry == 0) {
            return 0;
        }
        if (idx == n) {
            return carry; // last remaining element
        }
        if (memo[idx][carry] != -1) {
            return memo[idx][carry];
        }
        int result;
        if (carry == 0) {
            if (idx + 1 >= n) {
                result = nums[idx];
            } else {
                // Pick 2 of [nums[idx], nums[idx+1]] - only 2 elements possible
                // Actually we always have carry=0 and pick 2 from first available
                // Remove both nums[idx] and nums[idx+1] together
                result = Math.max(nums[idx], nums[idx + 1]) + solve(idx + 2, 0);
            }
        } else {
            // We have carry + nums[idx] + nums[idx+1] as "first three"
            if (idx + 1 >= n) {
                // only carry + nums[idx] remain (or just carry)
                result = Math.max(carry, nums[idx]);
            } else {
                int a = carry, b = nums[idx], c = nums[idx + 1];
                // Option 1: remove a and b, carry c
                int opt1 = Math.max(a, b) + solve(idx + 2, c);
                // Option 2: remove a and c, carry b
                int opt2 = Math.max(a, c) + solve(idx + 2, b);
                // Option 3: remove b and c, carry a
                int opt3 = Math.max(b, c) + solve(idx + 2, a);
                result = Math.min(opt1, Math.min(opt2, opt3));
            }
        }
        memo[idx][carry] = result;
        return result;
    }
}
