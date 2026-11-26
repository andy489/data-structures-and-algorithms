# https://leetcode.com/problems/car-pooling/

class Solution:
    def carPooling(self, trips: list[list[int]], capacity: int) -> bool:
        diff = [0] * 1001
        for n, frm, to in trips:
            diff[frm] += n
            diff[to] -= n
        cur = 0
        for d in diff:
            cur += d
            if cur > capacity:
                return False
        return True
