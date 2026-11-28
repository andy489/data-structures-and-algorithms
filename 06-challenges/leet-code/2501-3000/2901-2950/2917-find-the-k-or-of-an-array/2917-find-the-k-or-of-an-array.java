// https://leetcode.com/problems/find-the-k-or-of-an-array/

// Solution: Bit Counting — O(n * 31) time, O(1) space
class Solution {
    public int findKOr(int[] nums, int k) {
        int result = 0;
        for (int b = 0; b < 31; b++) {
            int count = 0;
            for (int num : nums) {
                if (((num >> b) & 1) == 1) {
                    count++;
                }
            }
            if (count >= k) {
                result |= (1 << b);
            }
        }
        return result;
    }
}
