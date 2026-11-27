# https://leetcode.com/problems/minimum-capacity-box/

from typing import List

class Solution:
    def minimumCapacityBox(self, capacity: List[int], itemSize: int) -> int:
        best_idx, best_cap = -1, float('inf')
        for i, c in enumerate(capacity):
            if c >= itemSize and c < best_cap:
                best_cap = c
                best_idx = i
        return best_idx
