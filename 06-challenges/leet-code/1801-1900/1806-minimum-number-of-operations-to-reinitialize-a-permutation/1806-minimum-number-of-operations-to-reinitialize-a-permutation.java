// https://leetcode.com/problems/minimum-number-of-operations-to-reinitialize-a-permutation/

// Solution: Simulation — O(n^2) time, O(n) space
class Solution {
    public int reinitializePermutation(int n) {
        int[] perm = new int[n];
        int[] orig = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i;
            orig[i] = i;
        }
        int ops = 0;
        do {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    arr[i] = perm[i / 2];
                } else {
                    arr[i] = perm[n / 2 + (i - 1) / 2];
                }
            }
            perm = arr;
            ops++;
        } while (!Arrays.equals(perm, orig));
        return ops;
    }
}
