# https://leetcode.com/problems/maximum-students-taking-exam/

class Solution:
    def maxStudents(self, seats: list[list[str]]) -> int:
        m, n = len(seats), len(seats[0])
        valid = [sum(1<<j for j in range(n) if seats[i][j]=='.') for i in range(m)]
        dp = [[-1]*(1<<n) for _ in range(m+1)]
        dp[0][0] = 0
        ans = 0
        for i in range(m):
            for prev in range(1<<n):
                if dp[i][prev] < 0:
                    continue
                for cur in range(1<<n):
                    if cur & valid[i] != cur:
                        continue
                    if cur & (cur>>1):
                        continue
                    if prev & (cur<<1) or prev & (cur>>1):
                        continue
                    students = dp[i][prev] + bin(cur).count('1')
                    if dp[i+1][cur] < students:
                        dp[i+1][cur] = students
                        ans = max(ans, students)
        return ans
