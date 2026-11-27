# https://leetcode.com/problems/finding-the-users-active-minutes/

from collections import defaultdict

class Solution:
    def findingUsersActiveMinutes(self, logs: list[list[int]], k: int) -> list[int]:
        uam = defaultdict(set)
        for uid, t in logs:
            uam[uid].add(t)
        ans = [0] * k
        for minutes in uam.values():
            cnt = len(minutes)
            if cnt <= k:
                ans[cnt - 1] += 1
        return ans
