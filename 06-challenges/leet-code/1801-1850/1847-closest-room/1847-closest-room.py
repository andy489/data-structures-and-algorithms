# https://leetcode.com/problems/closest-room/

from sortedcontainers import SortedList

class Solution:
    def closestRoom(self, rooms: list[list[int]], queries: list[list[int]]) -> list[int]:
        rooms.sort(key=lambda x: -x[1])
        indexed_queries = sorted(enumerate(queries), key=lambda x: -x[1][1])
        ids = SortedList()
        ans = [-1] * len(queries)
        ri = 0
        for orig, (preferred, min_size) in indexed_queries:
            while ri < len(rooms) and rooms[ri][1] >= min_size:
                ids.add(rooms[ri][0])
                ri += 1
            if not ids:
                continue
            pos = ids.bisect_left(preferred)
            best = -1
            best_diff = float('inf')
            for p in [pos - 1, pos]:
                if 0 <= p < len(ids):
                    diff = abs(ids[p] - preferred)
                    if diff < best_diff or (diff == best_diff and ids[p] > best):
                        best_diff = diff
                        best = ids[p]
            ans[orig] = best
        return ans
