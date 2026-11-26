# https://leetcode.com/problems/three-equal-parts/

class Solution:
    def threeEqualParts(self, arr: list) -> list:
        ones = [i for i, x in enumerate(arr) if x == 1]
        if not ones:
            return [0, 2]
        if len(ones) % 3 != 0:
            return [-1, -1]
        each = len(ones) // 3
        i1, i2, i3 = ones[0], ones[each], ones[2 * each]
        n = len(arr)
        while i3 < n and arr[i1] == arr[i2] == arr[i3]:
            i1 += 1
            i2 += 1
            i3 += 1
        return [i1 - 1, i2] if i3 == n else [-1, -1]
