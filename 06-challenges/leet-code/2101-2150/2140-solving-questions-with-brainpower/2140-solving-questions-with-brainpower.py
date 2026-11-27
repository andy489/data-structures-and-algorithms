# https://leetcode.com/problems/solving-questions-with-brainpower/
class Solution:
    def mostPoints(self, questions: list) -> int:
        n = len(questions)
        dp = [0] * (n + 1)
        for i in range(n - 1, -1, -1):
            points, skip = questions[i]
            next_q = min(n, i + skip + 1)
            dp[i] = max(dp[i + 1], points + dp[next_q])
        return dp[0]
