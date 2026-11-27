// https://leetcode.com/problems/single-number/

// Solution: XOR Bit Trick — O(n) time, O(1) space
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
