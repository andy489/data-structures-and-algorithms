# https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/

class Solution:
    def minOperations(self, boxes: str) -> list[int]:
        n = len(boxes)
        ans = [0] * n
        balls = ops = 0
        for i in range(n):
            ans[i] += ops
            balls += int(boxes[i])
            ops += balls
        balls = ops = 0
        for i in range(n - 1, -1, -1):
            ans[i] += ops
            balls += int(boxes[i])
            ops += balls
        return ans
