# https://leetcode.com/problems/maximum-coins-from-k-consecutive-bags/
import bisect

class Solution:
    def maximumCoins(self, coins: list[list[int]], k: int) -> int:
        coins.sort()
        n = len(coins)
        prefix = [0] * (n + 1)
        for i in range(n):
            prefix[i + 1] = prefix[i] + (coins[i][1] - coins[i][0] + 1) * coins[i][2]

        def coins_in_range(L, R):
            # Find first segment with right >= L
            lo, hi = 0, n
            while lo < hi:
                mid = (lo + hi) // 2
                if coins[mid][1] < L:
                    lo = mid + 1
                else:
                    hi = mid
            start = lo

            # Find last segment with left <= R
            lo, hi = 0, n
            while lo < hi:
                mid = (lo + hi) // 2
                if coins[mid][0] <= R:
                    lo = mid + 1
                else:
                    hi = mid
            end = lo - 1

            if start > end:
                return 0

            total = prefix[end + 1] - prefix[start]
            if coins[start][0] < L:
                total -= (L - coins[start][0]) * coins[start][2]
            if coins[end][1] > R:
                total -= (coins[end][1] - R) * coins[end][2]
            return total

        ans = 0
        for i in range(n):
            L = coins[i][0]
            ans = max(ans, coins_in_range(L, L + k - 1))
            R = coins[i][1]
            ans = max(ans, coins_in_range(R - k + 1, R))

        return ans
