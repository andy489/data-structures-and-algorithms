// https://leetcode.com/problems/bag-of-tokens/

// Solution: Sort + Two Pointers — O(n log n) time, O(1) space
class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        java.util.Arrays.sort(tokens);
        int lo = 0, hi = tokens.length - 1, score = 0, maxScore = 0;
        while (lo <= hi) {
            if (power >= tokens[lo]) {
                power -= tokens[lo++];
                maxScore = Math.max(maxScore, ++score);
            } else if (score > 0) {
                power += tokens[hi--];
                score--;
            } else {
                break;
            }
        }
        return maxScore;
    }
}
