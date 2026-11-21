// https://leetcode.com/problems/single-number-ii/

// Solution 1: Bit count per position — O(n) time, O(1) space
class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int b = 0; b < 32; b++) {
            int count = 0;
            for (int n : nums) {
                count += (n >> b) & 1;
            }
            if (count % 3 != 0) {
                ans |= (1 << b);
            }
        }
        return ans;
    }
}

// Solution 2: ones/twos bit trick — O(n) time, O(1) space
class Solution2 {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for (int x : nums) {
            ones = (ones ^ x) & ~twos;
            twos = (twos ^ x) & ~ones;
        }
        return ones;
    }
}
