// https://leetcode.com/problems/transform-array-by-parity/

// Solution: Count Odds — O(n) time, O(1) space
class Solution {
    public int[] transformArray(int[] nums) {
        int oddCount = 0;
        for (int num : nums) {
            if (num % 2 != 0) {
                oddCount++;
            }
        }
        int[] result = new int[nums.length];
        for (int i = nums.length - oddCount; i < nums.length; i++) {
            result[i] = 1;
        }
        return result;
    }
}
