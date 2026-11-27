# https://leetcode.com/problems/execution-of-all-suffix-instructions-staying-in-a-grid/
class Solution:
    def executeInstructions(self, n: int, startPos: list[int], s: str) -> list[int]:
        m = len(s)
        answer = []
        dirs = {'L': (0, -1), 'R': (0, 1), 'U': (-1, 0), 'D': (1, 0)}
        for i in range(m):
            r, c = startPos
            count = 0
            for j in range(i, m):
                dr, dc = dirs[s[j]]
                r += dr
                c += dc
                if r < 0 or r >= n or c < 0 or c >= n:
                    break
                count += 1
            answer.append(count)
        return answer
