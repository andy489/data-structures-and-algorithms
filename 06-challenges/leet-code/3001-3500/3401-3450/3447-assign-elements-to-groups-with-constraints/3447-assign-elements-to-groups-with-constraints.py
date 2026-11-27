# https://leetcode.com/problems/assign-elements-to-groups-with-constraints/
from typing import List

class Solution:
    def assignElements(self, groups: List[int], elements: List[int]) -> List[int]:
        max_g = max(groups)
        lookup = [-1] * (max_g + 1)

        for j in range(len(elements) - 1, -1, -1):
            e = elements[j]
            if e > max_g:
                continue
            for multiple in range(e, max_g + 1, e):
                lookup[multiple] = j

        return [lookup[g] for g in groups]
