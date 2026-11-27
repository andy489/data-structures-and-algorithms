# https://leetcode.com/problems/delivering-boxes-from-storage-to-ports/

from collections import deque

class Solution:
    def boxDelivering(self, boxes: list[list[int]], portsCount: int, maxBoxes: int, maxWeight: int) -> int:
        n = len(boxes)
        diff = [0] + [1 if boxes[i][0] != boxes[i - 1][0] else 0 for i in range(1, n)]
        dp = [0] * (n + 1)
        dq = deque([0])  # stores indices into dp; front has minimum dp value in window
        weight = 0
        trips = 0
        l = 0
        for r in range(n):
            weight += boxes[r][1]
            if r > 0:
                trips += diff[r]
            while r - l + 1 > maxBoxes or weight > maxWeight:
                weight -= boxes[l][1]
                if l + 1 <= r:
                    trips -= diff[l + 1]
                l += 1
                if dq and dq[0] < l:
                    dq.popleft()
            # dp[r+1] = dp[l] + trips(l..r) + 2
            dp[r + 1] = dp[dq[0]] + trips - (0 if dq[0] == 0 else sum(diff[dq[0]+1:l+1])) + 2
            # Simpler: recompute properly
            dp[r + 1] = dp[l] + trips + 2
            # Optimization: if same port as previous, we can extend previous trip
            if r > 0 and boxes[r][0] == boxes[r - 1][0]:
                dp[r + 1] = min(dp[r + 1], dp[r])
            while dq and dp[dq[-1]] >= dp[r + 1]:
                dq.pop()
            dq.append(r + 1)
        return dp[n]
