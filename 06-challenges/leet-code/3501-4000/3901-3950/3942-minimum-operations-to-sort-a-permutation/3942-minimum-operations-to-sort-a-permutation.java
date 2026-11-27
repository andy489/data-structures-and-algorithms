// https://leetcode.com/problems/minimum-operations-to-sort-a-permutation/
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        // Check if nums is already sorted
        boolean sorted = true;
        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                sorted = false;
                break;
            }
        }
        if (sorted) {
            return 0;
        }
        // Check rotations of [0,1,...,n-1]: find position of 0
        // A rotation of sorted: nums[(pos+i)%n] == i for all i
        int pos0 = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                pos0 = i;
                break;
            }
        }
        boolean isRotSorted = true;
        for (int i = 0; i < n; i++) {
            if (nums[(pos0 + i) % n] != i) {
                isRotSorted = false;
                break;
            }
        }
        // Check rotations of [n-1,...,1,0]: find position of n-1
        int posN1 = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == n - 1) {
                posN1 = i;
                break;
            }
        }
        boolean isRotReverse = true;
        for (int i = 0; i < n; i++) {
            if (nums[(posN1 + i) % n] != n - 1 - i) {
                isRotReverse = false;
                break;
            }
        }
        if (!isRotSorted && !isRotReverse) {
            return -1;
        }
        int ans = Integer.MAX_VALUE;
        if (isRotSorted) {
            // rotate left pos0 times => pos0 ops
            ans = Math.min(ans, pos0);
        }
        if (isRotReverse) {
            // reverse (1 op) then rotate left (posN1 ops) = 1 + posN1
            // or rotate left (n - posN1) times then reverse (1 op) = n - posN1 + 1
            ans = Math.min(ans, 1 + posN1);
            ans = Math.min(ans, 1 + (n - posN1) % n);
        }
        return ans;
    }
}
