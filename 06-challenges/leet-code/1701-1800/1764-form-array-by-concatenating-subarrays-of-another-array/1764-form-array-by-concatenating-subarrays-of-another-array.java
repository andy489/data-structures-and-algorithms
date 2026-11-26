// https://leetcode.com/problems/form-array-by-concatenating-subarrays-of-another-array/

// Solution: Greedy Linear Scan — O(n * m) time, O(1) space
class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        int pos = 0;
        for (int[] g : groups) {
            boolean found = false;
            while (pos + g.length <= nums.length) {
                if (matches(g, nums, pos)) {
                    pos += g.length;
                    found = true;
                    break;
                }
                pos++;
            }
            if (!found) return false;
        }
        return true;
    }

    private boolean matches(int[] g, int[] nums, int start) {
        for (int i = 0; i < g.length; i++) {
            if (g[i] != nums[start + i]) return false;
        }
        return true;
    }
}
