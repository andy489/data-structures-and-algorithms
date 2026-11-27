// https://leetcode.com/problems/maximum-of-absolute-value-expression/

// Solution: Absolute Value Decomposition — O(n) time, O(1) space
class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int ans = 0;
        // 4 sign combinations for (s1, s2): (+,+), (+,-), (-,+), (-,-)
        int[] signs = {1, -1};
        for (int s1 : signs) {
            for (int s2 : signs) {
                int maxF = Integer.MIN_VALUE, minF = Integer.MAX_VALUE;
                int maxG = Integer.MIN_VALUE, minG = Integer.MAX_VALUE;
                for (int k = 0; k < n; k++) {
                    int f = s1 * arr1[k] + s2 * arr2[k] + k;
                    int g = s1 * arr1[k] + s2 * arr2[k] - k;
                    maxF = Math.max(maxF, f);
                    minF = Math.min(minF, f);
                    maxG = Math.max(maxG, g);
                    minG = Math.min(minG, g);
                }
                ans = Math.max(ans, Math.max(maxF - minF, maxG - minG));
            }
        }
        return ans;
    }
}
