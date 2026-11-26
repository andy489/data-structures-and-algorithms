# https://leetcode.com/problems/form-largest-integer-with-digits-that-add-up-to-target/

class Solution:
    def largestNumber(self, cost: list[int], target: int) -> str:
        dp = [float('-inf')] * (target + 1)
        dp[0] = 0
        for t in range(1, target + 1):
            for d in range(9):
                if cost[d] <= t and dp[t - cost[d]] != float('-inf'):
                    dp[t] = max(dp[t], dp[t - cost[d]] + 1)
        if dp[target] < 0:
            return "0"
        res = []
        rem = target
        while rem > 0:
            for d in range(8, -1, -1):
                if cost[d] <= rem and dp[rem - cost[d]] == dp[rem] - 1:
                    res.append(str(d + 1))
                    rem -= cost[d]
                    break
        return ''.join(res)
