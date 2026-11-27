# https://leetcode.com/problems/max-value-of-equation/

class Solution:
    def findMaxValueOfEquation(self, points: list[list[int]], k: int) -> int:
        from collections import deque
        dq = deque()
        ans = float('-inf')
        for x, y in points:
            while dq and x - dq[0][0] > k:
                dq.popleft()
            if dq:
                ans = max(ans, y + x + dq[0][1] - dq[0][0])
            while dq and dq[-1][1] - dq[-1][0] <= y - x:
                dq.pop()
            dq.append((x, y))
        return ans
