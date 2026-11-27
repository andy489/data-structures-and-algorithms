# https://leetcode.com/problems/maximum-total-beauty-of-the-gardens/

import bisect

class Solution:
    def maximumBeauty(self, flowers: list[int], newFlowers: int, target: int, full: int, partial: int) -> int:
        n = len(flowers)
        flowers = sorted(min(f, target) for f in flowers)

        prefix = [0] * (n + 1)
        for i in range(n):
            prefix[i + 1] = prefix[i] + flowers[i]

        ans = 0
        remaining = newFlowers

        for c in range(n + 1):
            if c > 0:
                cost = max(0, target - flowers[n - c])
                remaining -= cost
            if remaining < 0:
                break

            incomplete = n - c
            min_val = 0
            if incomplete > 0:
                lo, hi = 0, target - 1
                while lo < hi:
                    mid = (lo + hi + 1) // 2
                    idx = bisect.bisect_left(flowers, mid, 0, incomplete)
                    needed = mid * idx - prefix[idx]
                    if needed <= remaining:
                        lo = mid
                    else:
                        hi = mid - 1
                min_val = lo

            ans = max(ans, c * full + min_val * partial)

        return ans
