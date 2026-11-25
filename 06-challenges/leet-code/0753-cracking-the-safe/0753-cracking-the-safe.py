# https://leetcode.com/problems/cracking-the-safe/

class Solution:
    def crackSafe(self, n: int, k: int) -> str:
        visited = set()
        result = []

        def dfs(node):
            for d in range(k - 1, -1, -1):
                edge = node + str(d)
                if edge not in visited:
                    visited.add(edge)
                    dfs(node[1:] + str(d))
                    result.append(str(d))

        start = '0' * (n - 1)
        dfs(start)
        return start + ''.join(reversed(result))
