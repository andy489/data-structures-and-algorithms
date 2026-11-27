# https://leetcode.com/problems/building-boxes/

class Solution:
    def minimumBoxes(self, n: int) -> int:
        # Find largest h with tetrahedral number h*(h+1)*(h+2)//6 <= n
        h = 0
        total = 0
        while total + (h + 1) * (h + 2) // 2 <= n:
            h += 1
            total += h * (h + 1) // 2
        floor = h * (h + 1) // 2
        i = 1
        while total < n:
            total += i
            floor += 1
            i += 1
        return floor
