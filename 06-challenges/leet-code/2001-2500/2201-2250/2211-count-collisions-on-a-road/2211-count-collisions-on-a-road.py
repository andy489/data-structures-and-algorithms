# https://leetcode.com/problems/count-collisions-on-a-road/
class Solution:
    def countCollisions(self, directions: str) -> int:
        n = len(directions)
        left = 0
        while left < n and directions[left] == 'L':
            left += 1
        right = n - 1
        while right >= 0 and directions[right] == 'R':
            right -= 1
        return sum(1 for i in range(left, right + 1) if directions[i] != 'S')
