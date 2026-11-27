// https://leetcode.com/problems/put-marbles-in-bags/

// Solution: Sort Adjacent Pair Sums — O(n log n) time, O(n) space
class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        int[] pairSums = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            pairSums[i] = weights[i] + weights[i + 1];
        }
        Arrays.sort(pairSums);
        long diff = 0;
        for (int i = 0; i < k - 1; i++) {
            diff += pairSums[n - 2 - i] - pairSums[i];
        }
        return diff;
    }
}
