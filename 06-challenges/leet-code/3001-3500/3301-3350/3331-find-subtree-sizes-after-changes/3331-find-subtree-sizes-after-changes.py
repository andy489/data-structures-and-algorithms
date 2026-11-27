# https://leetcode.com/problems/find-subtree-sizes-after-changes/

# Solution: DFS + Ancestor Character Stack — O(n) time, O(n) space
class Solution:
    def findSubtreeSizes(self, parent: list[int], s: str) -> list[int]:
        n = len(parent)
        orig = [[] for _ in range(n)]
        for i in range(1, n):
            orig[parent[i]].append(i)

        char_stack: list[list[int]] = [[] for _ in range(26)]
        new_parent = list(parent)

        def dfs_reparent(x: int) -> None:
            c = ord(s[x]) - ord('a')
            if x != 0 and char_stack[c]:
                new_parent[x] = char_stack[c][-1]
            char_stack[c].append(x)
            for child in orig[x]:
                dfs_reparent(child)
            char_stack[c].pop()

        import sys
        sys.setrecursionlimit(200000)
        dfs_reparent(0)

        final = [[] for _ in range(n)]
        for i in range(1, n):
            final[new_parent[i]].append(i)

        ans = [0] * n

        def dfs_size(x: int) -> None:
            ans[x] = 1
            for child in final[x]:
                dfs_size(child)
                ans[x] += ans[child]

        dfs_size(0)
        return ans
