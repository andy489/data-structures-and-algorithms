// https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/

// Solution: Two Sum Variant with mod 60 — O(n) time, O(1) space
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] count = new int[60];
        int ans = 0;
        for (int t : time) {
            int r = t % 60;
            ans += count[(60 - r) % 60];
            count[r]++;
        }
        return ans;
    }
}
