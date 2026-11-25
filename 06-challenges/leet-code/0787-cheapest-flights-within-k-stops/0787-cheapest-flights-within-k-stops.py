# https://leetcode.com/problems/cheapest-flights-within-k-stops/

class Solution:
    def findCheapestPrice(self, n: int, flights: list[list[int]], src: int, dst: int, k: int) -> int:
        dist = [float('inf')] * n
        dist[src] = 0
        for _ in range(k + 1):
            temp = dist[:]
            for u, v, w in flights:
                if dist[u] != float('inf') and dist[u] + w < temp[v]:
                    temp[v] = dist[u] + w
            dist = temp
        return dist[dst] if dist[dst] != float('inf') else -1
