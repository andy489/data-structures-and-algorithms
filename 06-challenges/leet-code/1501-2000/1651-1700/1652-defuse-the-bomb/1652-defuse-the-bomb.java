// https://leetcode.com/problems/defuse-the-bomb/

// Solution: Prefix Sum on Doubled Array — O(n) time, O(n) space
class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];
        if (k == 0) {
            return result;
        }
        // build prefix sums on doubled array
        int[] prefix = new int[2 * n + 1];
        for (int i = 0; i < 2 * n; i++) {
            prefix[i + 1] = prefix[i] + code[i % n];
        }
        for (int i = 0; i < n; i++) {
            int lo, hi;
            if (k > 0) {
                lo = i + 1;
                hi = i + k;
            } else {
                lo = i - (-k) + n;
                hi = i - 1 + n;
            }
            result[i] = prefix[hi + 1] - prefix[lo];
        }
        return result;
    }
}
