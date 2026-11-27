# https://leetcode.com/problems/minimize-hamming-distance-after-swap-operations/

class Solution:
    def minimumHammingDistance(self, source: list[int], target: list[int], allowedSwaps: list[list[int]]) -> int:
        n = len(source)
        parent = list(range(n))

        def find(x):
            while parent[x] != x:
                parent[x] = parent[parent[x]]
                x = parent[x]
            return x

        for a, b in allowedSwaps:
            ra, rb = find(a), find(b)
            if ra != rb:
                parent[ra] = rb

        from collections import defaultdict, Counter
        groups = defaultdict(list)
        for i in range(n):
            groups[find(i)].append(i)

        dist = 0
        for indices in groups.values():
            freq = Counter(source[i] for i in indices)
            for i in indices:
                t = target[i]
                if freq[t] > 0:
                    freq[t] -= 1
                else:
                    dist += 1
        return dist
