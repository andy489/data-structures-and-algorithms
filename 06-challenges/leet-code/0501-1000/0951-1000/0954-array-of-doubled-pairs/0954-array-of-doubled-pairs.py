# https://leetcode.com/problems/array-of-doubled-pairs/

from collections import Counter

class Solution:
    def canReorderDoubled(self, arr: list[int]) -> bool:
        count = Counter(arr)
        for k in sorted(count, key=abs):
            if count[k] == 0:
                continue
            if count[2 * k] < count[k]:
                return False
            count[2 * k] -= count[k]
            count[k] = 0
        return True
