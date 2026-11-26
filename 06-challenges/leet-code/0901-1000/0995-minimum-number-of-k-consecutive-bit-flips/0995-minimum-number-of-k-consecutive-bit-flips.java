// https://leetcode.com/problems/minimum-number-of-k-consecutive-bit-flips/

// Solution: Sliding Window with Flip Count — O(n) time, O(n) space
class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int[] flip = new int[n];
        int flipped = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (i >= k) { flipped ^= flip[i - k]; }
            if ((nums[i] ^ flipped) == 0) {
                if (i + k > n) { return -1; }
                flip[i] = 1;
                flipped ^= 1;
                ans++;
            }
        }
        return ans;
    }
}
