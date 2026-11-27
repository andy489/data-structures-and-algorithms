// https://leetcode.com/problems/relative-ranks/

// Solution: Sort with Index Tracking — O(n log n) time, O(n) space
class Solution {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> score[b] - score[a]);
        String[] medals = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        String[] result = new String[n];
        for (int rank = 0; rank < n; rank++) {
            result[indices[rank]] = rank < 3 ? medals[rank] : String.valueOf(rank + 1);
        }
        return result;
    }
}
