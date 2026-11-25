// https://leetcode.com/problems/beautiful-array/

// Solution: Divide and Conquer — O(n log n) time, O(n log n) space
class Solution {
    public int[] beautifulArray(int n) {
        int[] result = {1};
        while (result.length < n) {
            int len = result.length;
            int[] next = new int[len * 2 + 1 > n ? (len * 2 > n ? (n % 2 == 1 ? (len + (len + 1) / 2) : len * 2) : len * 2) : len * 2];
            // simpler: generate for all then trim
            int[] all = new int[result.length * 2];
            for (int i = 0; i < result.length; i++) {
                all[i] = 2 * result[i] - 1;
                all[result.length + i] = 2 * result[i];
            }
            if (all.length <= n) {
                result = all;
            } else {
                result = new int[n];
                int idx = 0;
                for (int x : all) {
                    if (x <= n) {
                        result[idx++] = x;
                    }
                }
            }
        }
        return result;
    }
}
