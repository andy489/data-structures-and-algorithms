// https://leetcode.com/problems/k-concatenation-maximum-sum/

// Solution: Kadane + Total Sum — O(n) time, O(1) space
class Solution {
    private static final int MOD = 1_000_000_007;

    public int kConcatenationMaxSum(int[] arr, int k) {
        long total = 0;
        for (int x : arr) {
            total += x;
        }
        long maxSub1 = kadane(arr, 1);
        if (k == 1) {
            return (int) (maxSub1 % MOD);
        }
        long maxSub2 = kadane(arr, 2);
        if (total > 0) {
            return (int) ((maxSub2 + (long) (k - 2) * total) % MOD);
        }
        return (int) (maxSub2 % MOD);
    }

    private long kadane(int[] arr, int repeat) {
        long maxSum = 0;
        long cur = 0;
        int n = arr.length;
        for (int r = 0; r < repeat; r++) {
            for (int x : arr) {
                cur = Math.max(0, cur + x);
                maxSum = Math.max(maxSum, cur);
            }
        }
        return maxSum;
    }
}
