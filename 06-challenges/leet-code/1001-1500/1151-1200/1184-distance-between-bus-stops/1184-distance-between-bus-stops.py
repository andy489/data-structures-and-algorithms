# https://leetcode.com/problems/distance-between-bus-stops/

# Solution: Prefix Sum (Two-Direction Scan) — O(n) time, O(1) space
class Solution:
    def distanceBetweenBusStops(self, distance: list[int], start: int, destination: int) -> int:
        if start > destination:
            start, destination = destination, start
        total = sum(distance)
        clockwise = sum(distance[start:destination])
        return min(clockwise, total - clockwise)
