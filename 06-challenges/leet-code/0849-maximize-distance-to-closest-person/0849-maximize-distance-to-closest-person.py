# https://leetcode.com/problems/maximize-distance-to-closest-person/

class Solution:
    def maxDistToClosest(self, seats: list[int]) -> int:
        n = len(seats)
        ans, last = 0, -1
        for i in range(n):
            if seats[i] == 1:
                ans = i if last == -1 else max(ans, (i - last) // 2)
                last = i
        return max(ans, n - 1 - last)
