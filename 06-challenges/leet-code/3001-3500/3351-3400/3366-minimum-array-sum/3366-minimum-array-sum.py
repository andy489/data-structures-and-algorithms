# https://leetcode.com/problems/minimum-array-sum/

class Solution:
    def minArraySum(self, nums: list[int], k: int, op1: int, op2: int) -> int:
        INF = float('inf')
        dp = [[INF] * (op2 + 1) for _ in range(op1 + 1)]
        dp[0][0] = 0

        for x in nums:
            nxt = [[INF] * (op2 + 1) for _ in range(op1 + 1)]
            for i in range(op1 + 1):
                for j in range(op2 + 1):
                    cur = dp[i][j]
                    if cur == INF:
                        continue
                    # No op
                    nxt[i][j] = min(nxt[i][j], cur + x)
                    # Op1 only
                    if i < op1:
                        nxt[i + 1][j] = min(nxt[i + 1][j], cur + (x + 1) // 2)
                    # Op2 only
                    if j < op2 and x >= k:
                        nxt[i][j + 1] = min(nxt[i][j + 1], cur + x - k)
                    if i < op1 and j < op2:
                        # Op1 then Op2
                        after_op1 = (x + 1) // 2
                        if after_op1 >= k:
                            nxt[i + 1][j + 1] = min(nxt[i + 1][j + 1], cur + after_op1 - k)
                        # Op2 then Op1
                        if x >= k:
                            nxt[i + 1][j + 1] = min(nxt[i + 1][j + 1], cur + (x - k + 1) // 2)
            dp = nxt

        return min(dp[i][j] for i in range(op1 + 1) for j in range(op2 + 1))
