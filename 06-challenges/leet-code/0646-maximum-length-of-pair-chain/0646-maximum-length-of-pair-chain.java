// https://leetcode.com/problems/maximum-length-of-pair-chain/

// Solution: Greedy (Sort by Right) — O(n log n) time, O(1) space
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
        int chainEnd = Integer.MIN_VALUE;
        int count = 0;
        for (int[] pair : pairs) {
            if (pair[0] > chainEnd) {
                chainEnd = pair[1];
                count++;
            }
        }
        return count;
    }
}
