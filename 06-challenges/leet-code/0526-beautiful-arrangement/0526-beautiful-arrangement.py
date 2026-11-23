# https://leetcode.com/problems/beautiful-arrangement/

class Solution:
    def countArrangement(self, n: int) -> int:
        count = 0
        visited = [False] * (n + 1)

        def backtrack(pos: int) -> None:
            nonlocal count
            if pos > n:
                count += 1
                return
            for num in range(1, n + 1):
                if not visited[num] and (num % pos == 0 or pos % num == 0):
                    visited[num] = True
                    backtrack(pos + 1)
                    visited[num] = False

        backtrack(1)
        return count
