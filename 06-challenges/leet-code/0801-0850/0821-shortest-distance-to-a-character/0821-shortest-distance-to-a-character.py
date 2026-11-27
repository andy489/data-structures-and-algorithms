# https://leetcode.com/problems/shortest-distance-to-a-character/

class Solution:
    def shortestToChar(self, s: str, c: str) -> list[int]:
        n = len(s)
        ans = [0] * n
        prev = -float('inf')
        for i in range(n):
            if s[i] == c:
                prev = i
            ans[i] = i - prev
        prev = float('inf')
        for i in range(n - 1, -1, -1):
            if s[i] == c:
                prev = i
            ans[i] = min(ans[i], prev - i)
        return ans
