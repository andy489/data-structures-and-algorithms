# https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/

import math

# Solution: Math (Work Upwards) — O(log n) time, O(log n) space
class Solution:
    def pathInZigZagTree(self, label: int) -> List[int]:
        path = []
        while label >= 1:
            path.append(label)
            row = int(math.log2(label))
            row_min = 1 << row
            row_max = (1 << (row + 1)) - 1
            mirror = row_min + row_max - label
            label = mirror // 2
        return path[::-1]
