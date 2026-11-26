// https://leetcode.com/problems/number-of-times-binary-string-is-prefix-aligned/

// Solution: Track max — O(n) time, O(1) space
class Solution {
    public int numTimesAllBlue(int[] flips) {
        int maxFlipped = 0, count = 0;
        for (int i = 0; i < flips.length; i++) {
            maxFlipped = Math.max(maxFlipped, flips[i]);
            if (maxFlipped == i + 1) count++;
        }
        return count;
    }
}
