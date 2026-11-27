# https://leetcode.com/problems/longest-well-performing-interval/

class Solution:
    def longestWPI(self, hours: list[int]) -> int:
        seen = {}
        score = 0
        ans = 0
        for i, h in enumerate(hours):
            score += 1 if h > 8 else -1
            if score > 0:
                ans = i + 1
            else:
                if score - 1 in seen:
                    ans = max(ans, i - seen[score - 1])
            if score not in seen:
                seen[score] = i
        return ans
