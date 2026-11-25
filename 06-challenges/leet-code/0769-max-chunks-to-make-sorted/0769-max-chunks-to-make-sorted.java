// https://leetcode.com/problems/max-chunks-to-make-sorted/

// Solution: Max Tracking — O(n) time, O(1) space
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int chunks = 0, maxSoFar = 0;
        for (int i = 0; i < arr.length; i++) {
            maxSoFar = Math.max(maxSoFar, arr[i]);
            if (maxSoFar == i) {
                chunks++;
            }
        }
        return chunks;
    }
}
