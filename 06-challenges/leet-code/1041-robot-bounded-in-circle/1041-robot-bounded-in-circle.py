# https://leetcode.com/problems/robot-bounded-in-circle/

class Solution:
    def isRobotBounded(self, instructions: str) -> bool:
        x, y, dx, dy = 0, 0, 0, 1
        for c in instructions:
            if c == 'G':
                x += dx; y += dy
            elif c == 'L':
                dx, dy = -dy, dx
            else:
                dx, dy = dy, -dx
        return (x == 0 and y == 0) or (dx, dy) != (0, 1)
