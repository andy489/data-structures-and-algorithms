// https://leetcode.com/problems/maximize-the-confusion-of-an-exam/

// Solution: Sliding Window — O(n) time, O(1) space
class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(maxWindow(answerKey, k, 'T'), maxWindow(answerKey, k, 'F'));
    }
    private int maxWindow(String s, int k, char flip) {
        int l = 0, res = 0, cnt = 0;
        for (int r = 0; r < s.length(); r++) {
            if (s.charAt(r) == flip) { cnt++; }
            while (cnt > k) { if (s.charAt(l++) == flip) { cnt--; } }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
