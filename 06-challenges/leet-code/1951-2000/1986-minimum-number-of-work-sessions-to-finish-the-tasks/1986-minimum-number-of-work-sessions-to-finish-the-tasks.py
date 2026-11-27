# https://leetcode.com/problems/minimum-number-of-work-sessions-to-finish-the-tasks/

class Solution:
    def minSessions(self, tasks: List[int], sessionTime: int) -> int:
        n = len(tasks)
        total = 1 << n
        INF = float('inf')
        dp = [INF] * total
        rem = [0] * total
        dp[0] = 1
        rem[0] = sessionTime

        for mask in range(total):
            if dp[mask] == INF:
                continue
            for i in range(n):
                if mask & (1 << i):
                    continue
                new_mask = mask | (1 << i)
                if tasks[i] <= rem[mask]:
                    if dp[mask] < dp[new_mask] or (dp[mask] == dp[new_mask] and rem[mask] - tasks[i] > rem[new_mask]):
                        dp[new_mask] = dp[mask]
                        rem[new_mask] = rem[mask] - tasks[i]
                else:
                    if dp[mask] + 1 < dp[new_mask] or (dp[mask] + 1 == dp[new_mask] and sessionTime - tasks[i] > rem[new_mask]):
                        dp[new_mask] = dp[mask] + 1
                        rem[new_mask] = sessionTime - tasks[i]
        return dp[total - 1]
