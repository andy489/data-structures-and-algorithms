# https://leetcode.com/problems/time-needed-to-inform-all-employees/

from collections import defaultdict

class Solution:
    def numOfMinutes(self, n, headID, manager, informTime) -> int:
        children = defaultdict(list)
        for i, m in enumerate(manager):
            if m != -1:
                children[m].append(i)
        def dfs(emp):
            return informTime[emp] + max((dfs(c) for c in children[emp]), default=0)
        return dfs(headID)
