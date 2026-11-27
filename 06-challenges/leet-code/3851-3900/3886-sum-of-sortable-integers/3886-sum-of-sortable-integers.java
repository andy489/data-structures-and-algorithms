// https://leetcode.com/problems/sum-of-sortable-integers/

class Solution {
    private boolean isCyclicRotation(int[] orig, int start, int end, int[] sorted) {
        int k = end - start;
        // check multisets match first (already guaranteed if sorted globally)
        // check if orig[start..end-1] is a cyclic rotation of sorted[start..end-1]
        // use string doubling approach with simple scan
        // find where sorted[start] appears in orig[start..end-1]
        int firstVal = sorted[start];
        for (int offset = 0; offset < k; offset++) {
            if (orig[start + offset] == firstVal) {
                // check if rotation by offset matches
                boolean ok = true;
                for (int j = 0; j < k; j++) {
                    if (orig[start + (offset + j) % k] != sorted[start + j]) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    return true;
                }
            }
        }
        return false;
    }

    public int sumOfSortableIntegers(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int ans = 0;
        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }
            boolean sortable = true;
            for (int i = 0; i < n; i += k) {
                if (!isCyclicRotation(nums, i, i + k, sorted)) {
                    sortable = false;
                    break;
                }
            }
            if (sortable) {
                ans += k;
            }
        }
        return ans;
    }
}
