# https://leetcode.com/problems/smallest-missing-genetic-value-in-each-subtree/

class Solution:
    def smallestMissingValueSubtree(self, parents: list[int], nums: list[int]) -> list[int]:
        from sys import setrecursionlimit
        setrecursionlimit(200000)
        n = len(parents)
        children = [[] for _ in range(n)]
        for i in range(1, n):
            children[parents[i]].append(i)
        ans = [1] * n
        try:
            start = nums.index(1)
        except ValueError:
            return ans
        visited = set()
        mex = 1
        cur, prev = start, -1
        def dfs(node, skip):
            visited.add(nums[node])
            for c in children[node]:
                if c != skip:
                    dfs(c, -1)
        while cur != -1:
            dfs(cur, prev)
            while mex in visited:
                mex += 1
            ans[cur] = mex
            prev, cur = cur, parents[cur]
        return ans
