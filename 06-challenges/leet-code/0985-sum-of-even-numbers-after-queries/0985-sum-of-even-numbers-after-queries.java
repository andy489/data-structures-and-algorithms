// https://leetcode.com/problems/sum-of-even-numbers-after-queries/

// Solution: Running Even Sum — O(n+q) time, O(n+q) space
class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int evenSum = 0;
        for (int x : nums) { if (x % 2 == 0) { evenSum += x; } }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0], idx = queries[i][1];
            if (nums[idx] % 2 == 0) { evenSum -= nums[idx]; }
            nums[idx] += val;
            if (nums[idx] % 2 == 0) { evenSum += nums[idx]; }
            res[i] = evenSum;
        }
        return res;
    }
}
