# https://leetcode.com/problems/smallest-string-with-swaps/

class Solution:
    def smallestStringWithSwaps(self, s: str, pairs: list[list[int]]) -> str:
        n = len(s)
        parent = list(range(n))
        def find(x):
            while parent[x] != x:
                parent[x] = parent[parent[x]]
                x = parent[x]
            return x
        def union(x, y):
            parent[find(x)] = find(y)
        for a, b in pairs:
            union(a, b)
        from collections import defaultdict
        groups = defaultdict(list)
        for i in range(n):
            groups[find(i)].append(i)
        res = list(s)
        for indices in groups.values():
            chars = sorted(s[i] for i in indices)
            for i, idx in enumerate(sorted(indices)):
                res[idx] = chars[i]
        return ''.join(res)
