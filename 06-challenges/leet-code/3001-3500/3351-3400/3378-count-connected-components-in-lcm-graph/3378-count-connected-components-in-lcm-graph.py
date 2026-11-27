# https://leetcode.com/problems/count-connected-components-in-lcm-graph/

class Solution:
    def countComponents(self, nums: list[int], threshold: int) -> int:
        parent = list(range(threshold + 1))
        rank = [0] * (threshold + 1)

        def find(x: int) -> int:
            while parent[x] != x:
                parent[x] = parent[parent[x]]
                x = parent[x]
            return x

        def union(a: int, b: int) -> None:
            ra, rb = find(a), find(b)
            if ra == rb:
                return
            if rank[ra] < rank[rb]:
                ra, rb = rb, ra
            parent[rb] = ra
            if rank[ra] == rank[rb]:
                rank[ra] += 1

        present = set()
        isolated = 0
        for x in nums:
            if x > threshold:
                isolated += 1
            else:
                present.add(x)

        for d in range(1, threshold + 1):
            first = -1
            for multiple in range(d, threshold + 1, d):
                if multiple in present:
                    if first == -1:
                        first = multiple
                    else:
                        union(first, multiple)

        roots = {find(x) for x in nums if x <= threshold}
        return len(roots) + isolated
