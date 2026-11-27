# https://leetcode.com/problems/count-k-th-roots-in-a-range/

class Solution:
    def countKthRoots(self, l: int, r: int, k: int) -> int:
        if k == 1:
            return r - l + 1
        count = 0
        x = 0 if l == 0 else 1
        while True:
            power = x ** k
            if power > r:
                break
            if power >= l:
                count += 1
            x += 1
        return count
