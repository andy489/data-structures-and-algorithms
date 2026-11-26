# https://leetcode.com/problems/walking-robot-simulation/

class Solution:
    def robotSim(self, commands: list[int], obstacles: list[list[int]]) -> int:
        blocked = set(map(tuple, obstacles))
        dirs = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        d = x = y = ans = 0
        for cmd in commands:
            if cmd == -2:
                d = (d + 3) % 4
            elif cmd == -1:
                d = (d + 1) % 4
            else:
                dx, dy = dirs[d]
                for _ in range(cmd):
                    if (x + dx, y + dy) in blocked:
                        break
                    x += dx; y += dy
                    ans = max(ans, x * x + y * y)
        return ans
