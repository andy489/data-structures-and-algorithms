# https://leetcode.com/problems/maximum-performance-of-a-team/

import heapq

class Solution:
    def maxPerformance(self, n, speed, efficiency, k) -> int:
        MOD = 10**9 + 7
        eng = sorted(zip(efficiency, speed), reverse=True)
        heap = []
        sum_speed = best = 0
        for eff, spd in eng:
            heapq.heappush(heap, spd)
            sum_speed += spd
            if len(heap) > k:
                sum_speed -= heapq.heappop(heap)
            best = max(best, sum_speed * eff)
        return best % MOD
