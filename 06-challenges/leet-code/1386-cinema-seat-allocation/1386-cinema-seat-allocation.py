# https://leetcode.com/problems/cinema-seat-allocation/

from collections import defaultdict

class Solution:
    def maxNumberOfFamilies(self, n: int, reservedSeats) -> int:
        rows = defaultdict(int)
        for r, s in reservedSeats:
            if 2 <= s <= 9:
                rows[r] |= 1 << s
        count = 2 * (n - len(rows))
        left_mask  = sum(1<<s for s in [2,3,4,5])
        mid_mask   = sum(1<<s for s in [4,5,6,7])
        right_mask = sum(1<<s for s in [6,7,8,9])
        for mask in rows.values():
            left  = not (mask & left_mask)
            mid   = not (mask & mid_mask)
            right = not (mask & right_mask)
            if left and right:
                count += 2
            elif left or mid or right:
                count += 1
        return count
