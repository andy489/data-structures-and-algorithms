# https://leetcode.com/problems/find-servers-that-handled-most-number-of-requests/

from sortedcontainers import SortedList
import heapq

class Solution:
    def busiestServers(self, k: int, arrival: list[int], load: list[int]) -> list[int]:
        count = [0] * k
        available = SortedList(range(k))
        busy = []  # (finish_time, server_index)

        for i, (t, l) in enumerate(zip(arrival, load)):
            while busy and busy[0][0] <= t:
                _, server = heapq.heappop(busy)
                available.add(server)
            if not available:
                continue
            preferred = i % k
            idx = available.bisect_left(preferred)
            if idx == len(available):
                idx = 0
            server = available[idx]
            available.remove(server)
            count[server] += 1
            heapq.heappush(busy, (t + l, server))

        max_count = max(count)
        return [i for i in range(k) if count[i] == max_count]
