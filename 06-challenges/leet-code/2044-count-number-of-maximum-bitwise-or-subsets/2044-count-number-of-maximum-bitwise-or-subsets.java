// https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/

// Solution: Bitmask Enumeration — O(2^n) time, O(1) space
class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for (int x : nums) { maxOr |= x; }
        int count = 0;
        for (int mask = 1; mask < (1 << nums.length); mask++) {
            int or = 0;
            for (int i = 0; i < nums.length; i++) { if ((mask >> i & 1) == 1) { or |= nums[i]; } }
            if (or == maxOr) { count++; }
        }
        return count;
    }
}
