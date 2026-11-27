# https://leetcode.com/problems/pass-the-pillow/

class Solution:
    def passThePillow(self, n: int, time: int) -> int:
        cycle = 2 * (n - 1)
        time %= cycle
        if time < n:
            return time + 1
        else:
            return cycle - time + 1
