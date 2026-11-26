# https://leetcode.com/problems/similar-string-groups/

class Solution:
    def numSimilarGroups(self, strs: list[str]) -> int:
        n = len(strs)
        parent = list(range(n))

        def find(x):
            while parent[x] != x:
                parent[x] = parent[parent[x]]
                x = parent[x]
            return x

        def union(x, y):
            parent[find(x)] = find(y)

        def similar(a, b):
            diffs = sum(1 for x, y in zip(a, b) if x != y)
            return diffs == 0 or diffs == 2

        for i in range(n):
            for j in range(i + 1, n):
                if similar(strs[i], strs[j]):
                    union(i, j)

        return sum(find(i) == i for i in range(n))
