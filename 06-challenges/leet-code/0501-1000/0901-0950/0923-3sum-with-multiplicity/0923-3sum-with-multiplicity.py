# https://leetcode.com/problems/3sum-with-multiplicity/

from collections import Counter

class Solution:
    def threeSumMulti(self, arr: list, target: int) -> int:
        MOD = 10 ** 9 + 7
        count = Counter(arr)
        result = 0
        keys = sorted(count)
        for i, x in enumerate(keys):
            for j, y in enumerate(keys):
                if y < x:
                    continue
                z = target - x - y
                if z < y or z not in count:
                    continue
                if x == y == z:
                    c = count[x]
                    result += c * (c-1) * (c-2) // 6
                elif x == y:
                    c = count[x]
                    result += c * (c-1) // 2 * count[z]
                elif y == z:
                    c = count[y]
                    result += count[x] * c * (c-1) // 2
                else:
                    result += count[x] * count[y] * count[z]
        return result % MOD
