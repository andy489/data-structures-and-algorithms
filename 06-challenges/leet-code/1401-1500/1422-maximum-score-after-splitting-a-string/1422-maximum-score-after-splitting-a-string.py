# https://leetcode.com/problems/maximum-score-after-splitting-a-string/

class Solution:
    def maxScore(self, s: str) -> int:
        ones = s.count('1')
        score = ans = 0
        for c in s[:-1]:
            score += 1 if c == '0' else -1
            ans = max(ans, score + ones)
        return ans
