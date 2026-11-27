// https://leetcode.com/problems/maximum-possible-number-by-binary-concatenation/

class Solution {
    public int maxGoodNumber(int[] nums) {
        int best = 0;
        int[] perm = {0, 1, 2};
        do {
            int val = 0;
            for (int idx : perm) {
                int bits = Integer.SIZE - Integer.numberOfLeadingZeros(nums[idx]);
                val = (val << bits) | nums[idx];
            }
            best = Math.max(best, val);
        } while (nextPermutation(perm));
        return best;
    }

    private boolean nextPermutation(int[] a) {
        int n = a.length;
        int i = n - 2;
        while (i >= 0 && a[i] >= a[i + 1]) {
            i--;
        }
        if (i < 0) {
            return false;
        }
        int j = n - 1;
        while (a[j] <= a[i]) {
            j--;
        }
        int tmp = a[i]; a[i] = a[j]; a[j] = tmp;
        for (int l = i + 1, r = n - 1; l < r; l++, r--) {
            tmp = a[l]; a[l] = a[r]; a[r] = tmp;
        }
        return true;
    }
}
