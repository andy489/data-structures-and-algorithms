// https://leetcode.com/problems/maximum-xor-for-each-query/

// Solution: Prefix XOR — O(n) time, O(n) space
class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int mask = (1 << maximumBit) - 1;
        int xorAll = 0;
        for (int x : nums) {
            xorAll ^= x;
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = xorAll ^ mask;
            xorAll ^= nums[n - 1 - i];
        }
        return ans;
    }
}
