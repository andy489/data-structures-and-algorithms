# https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/

class Solution:
    def constructDistancedSequence(self, n: int) -> list[int]:
        size = 2 * n - 1
        result = [0] * size
        used = [False] * (n + 1)

        def backtrack(pos: int) -> bool:
            if pos == size:
                return True
            if result[pos] != 0:
                return backtrack(pos + 1)
            for v in range(n, 0, -1):
                if used[v]:
                    continue
                if v == 1:
                    result[pos] = 1
                    used[1] = True
                    if backtrack(pos + 1):
                        return True
                    result[pos] = 0
                    used[1] = False
                else:
                    second = pos + v
                    if second < size and result[second] == 0:
                        result[pos] = v
                        result[second] = v
                        used[v] = True
                        if backtrack(pos + 1):
                            return True
                        result[pos] = 0
                        result[second] = 0
                        used[v] = False
            return False

        backtrack(0)
        return result
