// https://leetcode.com/problems/total-hamming-distance/

// Solution: Bit Counting — O(32 * N) time, O(1) space
class Solution {
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        int n = nums.length;
        for (int bit = 0; bit < 32; bit++) {
            int onesCount = 0;
            for (int num : nums) {
                onesCount += (num >> bit) & 1;
            }
            total += onesCount * (n - onesCount);
        }
        return total;
    }
}
