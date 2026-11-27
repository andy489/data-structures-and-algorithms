# https://leetcode.com/problems/count-pairs-of-nodes/

from collections import defaultdict

class Solution:
    def countPairs(self, n: int, edges: list[list[int]], queries: list[int]) -> list[int]:
        deg = [0] * (n + 1)
        shared = defaultdict(int)

        for u, v in edges:
            deg[u] += 1
            deg[v] += 1
            key = (min(u, v), max(u, v))
            shared[key] += 1

        sorted_deg = sorted(deg[1:])
        ans = []

        for threshold in queries:
            count = 0
            lo, hi = 0, n - 1
            while lo < hi:
                if sorted_deg[lo] + sorted_deg[hi] > threshold:
                    count += hi - lo
                    hi -= 1
                else:
                    lo += 1
            for (u, v), cnt in shared.items():
                if deg[u] + deg[v] > threshold >= deg[u] + deg[v] - cnt:
                    count -= 1
            ans.append(count)

        return ans
