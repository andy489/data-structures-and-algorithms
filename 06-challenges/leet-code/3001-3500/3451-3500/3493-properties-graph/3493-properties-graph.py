# https://leetcode.com/problems/properties-graph/

class Solution:
    def numberOfComponents(self, properties: list[list[int]], k: int) -> int:
        n = len(properties)
        sets = [set(row) for row in properties]

        parent = list(range(n))

        def find(x):
            while parent[x] != x:
                parent[x] = parent[parent[x]]
                x = parent[x]
            return x

        def union(a, b):
            ra, rb = find(a), find(b)
            if ra != rb:
                parent[ra] = rb

        for i in range(n):
            for j in range(i + 1, n):
                if len(sets[i] & sets[j]) >= k:
                    union(i, j)

        return len({find(i) for i in range(n)})
