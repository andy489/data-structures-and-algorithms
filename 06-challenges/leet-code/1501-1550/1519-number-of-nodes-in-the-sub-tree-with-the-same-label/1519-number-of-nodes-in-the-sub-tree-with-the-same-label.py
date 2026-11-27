# https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/

import sys
sys.setrecursionlimit(200000)

class Solution:
    def countSubTrees(self, n: int, edges, labels: str):
        adj = [[] for _ in range(n)]
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)
        ans = [0] * n

        def dfs(node, parent):
            freq = [0] * 26
            freq[ord(labels[node]) - ord('a')] += 1
            for child in adj[node]:
                if child == parent:
                    continue
                child_freq = dfs(child, node)
                for i in range(26):
                    freq[i] += child_freq[i]
            ans[node] = freq[ord(labels[node]) - ord('a')]
            return freq

        dfs(0, -1)
        return ans
