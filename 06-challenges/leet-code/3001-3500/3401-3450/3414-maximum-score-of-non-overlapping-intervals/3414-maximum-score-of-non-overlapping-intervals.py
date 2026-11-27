# https://leetcode.com/problems/maximum-score-of-non-overlapping-intervals/
import bisect

class Solution:
    def maximumWeight(self, intervals: list[list[int]]) -> list[int]:
        n = len(intervals)
        # arr[i] = [left, right, weight, original_index]
        arr = [[intervals[i][0], intervals[i][1], intervals[i][2], i] for i in range(n)]
        # Sort by right, then left, then original index
        arr.sort(key=lambda x: (x[1], x[0], x[3]))

        rights = [x[1] for x in arr]
        K = 4
        # dp[k][i] = max sum using exactly k intervals, last being arr[i]
        INF = float('-inf')
        dp = [[INF] * n for _ in range(K + 1)]
        prev_idx = [[-1] * n for _ in range(K + 1)]

        for k in range(1, K + 1):
            for i in range(n):
                left = arr[i][0]
                # Find last j where arr[j][1] < left (strict)
                j = bisect.bisect_left(rights, left) - 1
                if k == 1:
                    dp[k][i] = arr[i][2]
                    prev_idx[k][i] = -1
                elif j >= 0 and dp[k - 1][j] != INF:
                    dp[k][i] = dp[k - 1][j] + arr[i][2]
                    prev_idx[k][i] = j

        # Find best answer
        best_val = INF
        best_k, best_i = -1, -1
        for k in range(1, K + 1):
            for i in range(n):
                if dp[k][i] != INF and dp[k][i] > best_val:
                    best_val = dp[k][i]
                    best_k, best_i = k, i

        # Reconstruct
        result = []
        cur_k, cur_i = best_k, best_i
        while cur_i >= 0 and cur_k >= 1:
            result.append(arr[cur_i][3])
            next_i = prev_idx[cur_k][cur_i]
            cur_k -= 1
            cur_i = next_i

        result.sort()
        return result
