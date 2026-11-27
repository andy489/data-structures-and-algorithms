// https://leetcode.com/problems/number-of-ways-to-reorder-array-to-get-same-bst/

// Solution: Divide and Conquer with Combinatorics — O(n^2) time, O(n^2) space
class Solution {
    static final int MOD = 1_000_000_007;
    long[][] C;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        C = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            C[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % MOD;
            }
        }
        java.util.List<Integer> list = new java.util.ArrayList<>();
        for (int x : nums) {
            list.add(x);
        }
        return (int) ((count(list) - 1 + MOD) % MOD);
    }

    private long count(java.util.List<Integer> nums) {
        if (nums.size() <= 2) {
            return 1;
        }
        int root = nums.get(0);
        java.util.List<Integer> left = new java.util.ArrayList<>();
        java.util.List<Integer> right = new java.util.ArrayList<>();
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) < root) {
                left.add(nums.get(i));
            } else {
                right.add(nums.get(i));
            }
        }
        long l = count(left), r = count(right);
        return C[left.size() + right.size()][left.size()] % MOD * l % MOD * r % MOD;
    }
}
