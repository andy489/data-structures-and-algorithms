# https://leetcode.com/problems/find-original-array-from-doubled-array/

class Solution:
    def findOriginalArray(self, changed: list[int]) -> list[int]:
        if len(changed) % 2 != 0:
            return []
        changed.sort()
        from collections import Counter
        freq = Counter(changed)
        original = []
        for x in changed:
            if freq[x] == 0:
                continue
            freq[x] -= 1
            if freq[2 * x] == 0:
                return []
            freq[2 * x] -= 1
            original.append(x)
        return original
