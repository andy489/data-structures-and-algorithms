# https://leetcode.com/problems/longest-path-with-different-adjacent-characters/

from collections import defaultdict

class Solution:
    def longestPath(self, parent: list[int], s: str) -> int:
        children = defaultdict(list)
        for i in range(1, len(parent)):
            children[parent[i]].append(i)

        self.ans = 1

        def dfs(node: int) -> int:
            top1 = top2 = 0
            for child in children[node]:
                length = dfs(child)
                if s[child] == s[node]:
                    continue
                if length > top1:
                    top2, top1 = top1, length
                elif length > top2:
                    top2 = length
            self.ans = max(self.ans, top1 + top2 + 1)
            return top1 + 1

        dfs(0)
        return self.ans
