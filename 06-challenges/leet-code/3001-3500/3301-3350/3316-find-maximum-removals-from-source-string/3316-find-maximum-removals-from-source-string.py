# https://leetcode.com/problems/find-maximum-removals-from-source-string/

from typing import List


class Solution:
    def maxRemovals(self, source: str, pattern: str, targetIndices: List[int]) -> int:
        n, m = len(source), len(pattern)
        targets = set(targetIndices)
        NEG_INF = float('-inf')
        dp = [NEG_INF] * (m + 1)
        dp[0] = 0
        for i in range(n):
            ndp = dp[:]
            is_target = i in targets
            for j in range(m + 1):
                if dp[j] == NEG_INF:
                    continue
                if is_target:
                    ndp[j] = max(ndp[j], dp[j] + 1)
                if j < m and source[i] == pattern[j]:
                    ndp[j + 1] = max(ndp[j + 1], dp[j])
            dp = ndp
        return dp[m]
