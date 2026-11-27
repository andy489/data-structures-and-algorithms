// https://leetcode.com/problems/digit-frequency-score/
class Solution {
    public int digitScore(int n) {
        int[] freq = new int[10];
        while (n > 0) {
            freq[n % 10]++;
            n /= 10;
        }
        int score = 0;
        for (int d = 0; d <= 9; d++) {
            score += d * freq[d];
        }
        return score;
    }
}
