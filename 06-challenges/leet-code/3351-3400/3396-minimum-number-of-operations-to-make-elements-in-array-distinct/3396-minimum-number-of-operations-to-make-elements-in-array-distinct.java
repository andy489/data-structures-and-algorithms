// https://leetcode.com/problems/minimum-number-of-operations-to-make-elements-in-array-distinct/

// Solution: Scan from Right — O(n) time, O(n) space
class Solution {
    public int minimumOperations(int[] nums) {
        boolean[] seen = new boolean[101];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (seen[nums[i]]) {
                return i / 3 + 1;
            }
            seen[nums[i]] = true;
        }
        return 0;
    }
}
