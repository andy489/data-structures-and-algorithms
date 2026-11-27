// https://leetcode.com/problems/transformed-array/

// Solution: Direct Simulation — O(n) time, O(n) space
class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                result[i] = 0;
            } else {
                int j = ((i + nums[i]) % n + n) % n;
                result[i] = nums[j];
            }
        }
        return result;
    }
}
