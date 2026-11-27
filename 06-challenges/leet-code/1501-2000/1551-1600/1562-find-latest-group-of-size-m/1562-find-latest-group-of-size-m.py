# https://leetcode.com/problems/find-latest-group-of-size-m/

class Solution:
    def findLatestStep(self, arr: list[int], m: int) -> int:
        n = len(arr)
        size = [0] * (n + 2)
        parent = list(range(n + 2))
        active = [False] * (n + 2)
        group_count = [0] * (n + 1)
        result = -1

        def find(x: int) -> int:
            while parent[x] != x:
                parent[x] = parent[parent[x]]
                x = parent[x]
            return x

        def union(a: int, b: int) -> None:
            ra, rb = find(a), find(b)
            if ra == rb:
                return
            group_count[size[ra]] -= 1
            group_count[size[rb]] -= 1
            if size[ra] < size[rb]:
                parent[ra] = rb
                size[rb] += size[ra]
                group_count[size[rb]] += 1
            else:
                parent[rb] = ra
                size[ra] += size[rb]
                group_count[size[ra]] += 1

        for step, pos in enumerate(arr, 1):
            active[pos] = True
            size[pos] = 1
            group_count[1] += 1
            if active[pos - 1]:
                union(pos - 1, pos)
            if active[pos + 1]:
                union(pos, pos + 1)
            if group_count[m] > 0:
                result = step
        return result
