# https://leetcode.com/problems/most-beautiful-item-for-each-query/

class Solution:
    def maximumBeauty(self, items: list[list[int]], queries: list[int]) -> list[int]:
        items.sort()
        sorted_q = sorted(enumerate(queries), key=lambda x: x[1])
        res = [0] * len(queries)
        j = max_b = 0
        for idx, q in sorted_q:
            while j < len(items) and items[j][0] <= q:
                max_b = max(max_b, items[j][1])
                j += 1
            res[idx] = max_b
        return res
