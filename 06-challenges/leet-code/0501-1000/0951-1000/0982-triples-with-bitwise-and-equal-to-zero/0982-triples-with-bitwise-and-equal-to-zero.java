// https://leetcode.com/problems/triples-with-bitwise-and-equal-to-zero/

// Solution: Two-Pass with Pair Counts — O(n² + n·2^16) time, O(2^16) space
class Solution {
    public int countTriplets(int[] nums) {
        int[] pairCount = new int[1 << 16];
        for (int a : nums) {
            for (int b : nums) {
                pairCount[a & b]++;
            }
        }
        int ans = 0;
        for (int c : nums) {
            for (int v = 0; v < (1 << 16); v++) {
                if (pairCount[v] > 0 && (v & c) == 0) {
                    ans += pairCount[v];
                }
            }
        }
        return ans;
    }
}
