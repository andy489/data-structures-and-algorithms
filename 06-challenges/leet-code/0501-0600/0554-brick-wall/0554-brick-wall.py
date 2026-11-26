# https://leetcode.com/problems/brick-wall/
# Solution: HashMap edge frequency — O(n·w) time, O(w) space
from collections import defaultdict

class Solution:
    def leastBricks(self, wall: list[list[int]]) -> int:
        edge_count = defaultdict(int)
        for row in wall:
            prefix = 0
            for brick in row[:-1]:
                prefix += brick
                edge_count[prefix] += 1
        max_edges = max(edge_count.values()) if edge_count else 0
        return len(wall) - max_edges
