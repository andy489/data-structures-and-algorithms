// https://leetcode.com/problems/missing-number/

// Solution 1: Gauss Sum — O(n) time, O(1) space
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expected = n * (n + 1) / 2;
        for (int num : nums) {
            expected -= num;
        }
        return expected;
    }
}

// Solution 2: XOR — O(n) time, O(1) space
class Solution2 {
    public int missingNumber(int[] nums) {
        int xor = nums.length;
        for (int i = 0; i < nums.length; i++) {
            xor ^= i ^ nums[i];
        }
        return xor;
    }
}
