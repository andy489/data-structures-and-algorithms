// https://leetcode.com/problems/beautiful-arrangement-ii/

// Solution: Zigzag Construction — O(n) time, O(n) space
class Solution {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int lo = 1, hi = k + 1, idx = 0;
        for (int i = 0; i < k + 1; i++) {
            res[idx++] = (i % 2 == 0) ? lo++ : hi--;
        }
        for (int i = k + 2; i <= n; i++) {
            res[idx++] = i;
        }
        return res;
    }
}
