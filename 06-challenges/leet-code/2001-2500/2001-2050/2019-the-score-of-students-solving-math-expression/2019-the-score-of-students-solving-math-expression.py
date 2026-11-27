# https://leetcode.com/problems/the-score-of-students-solving-math-expression/

class Solution:
    def scoreOfStudents(self, s: str, answers: list[int]) -> int:
        import ast
        correct = eval(s)
        nums = [int(c) for c in s if c.isdigit()]
        ops = [c for c in s if c in '+*']
        n = len(nums)
        dp = [[set() for _ in range(n)] for _ in range(n)]
        for i in range(n):
            dp[i][i] = {nums[i]}
        for length in range(2, n + 1):
            for i in range(n - length + 1):
                j = i + length - 1
                for k in range(i, j):
                    op = ops[k]
                    for a in dp[i][k]:
                        for b in dp[k+1][j]:
                            v = a + b if op == '+' else a * b
                            if v <= 1000:
                                dp[i][j].add(v)
        total = 0
        for ans in answers:
            if ans == correct:
                total += 5
            elif ans in dp[0][n-1]:
                total += 2
        return total
