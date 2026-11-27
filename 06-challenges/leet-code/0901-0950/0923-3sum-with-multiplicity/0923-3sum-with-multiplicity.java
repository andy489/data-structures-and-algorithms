// https://leetcode.com/problems/3sum-with-multiplicity/

// Solution: Count + Combinatorics — O(101²) time, O(101) space
class Solution {
    public int threeSumMulti(int[] arr, int target) {
        long MOD = 1_000_000_007L;
        long[] count = new long[101];
        for (int x : arr) {
            count[x]++;
        }
        long result = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = i; j <= 100; j++) {
                int k = target - i - j;
                if (k < 0 || k > 100 || k < j) {
                    continue;
                }
                if (i == j && j == k) {
                    result += count[i] * (count[i] - 1) * (count[i] - 2) / 6;
                } else if (i == j) {
                    result += count[i] * (count[i] - 1) / 2 * count[k];
                } else if (j == k) {
                    result += count[i] * count[j] * (count[j] - 1) / 2;
                } else {
                    result += count[i] * count[j] * count[k];
                }
            }
        }
        return (int)(result % MOD);
    }
}
