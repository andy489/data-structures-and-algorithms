# https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/

class Solution:
    def getLastMoment(self, n: int, left, right) -> int:
        ans = 0
        for pos in left:
            ans = max(ans, pos)
        for pos in right:
            ans = max(ans, n - pos)
        return ans
