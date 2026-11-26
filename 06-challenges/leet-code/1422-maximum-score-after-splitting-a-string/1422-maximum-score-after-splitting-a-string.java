// https://leetcode.com/problems/maximum-score-after-splitting-a-string/

// Solution: One Pass — O(n) time, O(1) space
class Solution {
    public int maxScore(String s) {
        int ones = 0;
        for (char c : s.toCharArray()) if (c == '1') ones++;
        int score = 0, ans = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') score++;
            else { score--; }
            ans = Math.max(ans, score + ones);
        }
        return ans;
    }
}
