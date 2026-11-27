# https://leetcode.com/problems/maximum-points-activated-with-one-addition/

class Solution:
    def maxActivated(self, points: list[list[int]]) -> int:
        n = len(points)
        parent = list(range(n))
        size = [1] * n

        def find(x):
            while parent[x] != x:
                parent[x] = parent[parent[x]]
                x = parent[x]
            return x

        def union(a, b):
            ra, rb = find(a), find(b)
            if ra == rb:
                return
            if size[ra] < size[rb]:
                ra, rb = rb, ra
            parent[rb] = ra
            size[ra] += size[rb]

        from collections import defaultdict
        by_x = defaultdict(list)
        by_y = defaultdict(list)
        for i, (x, y) in enumerate(points):
            by_x[x].append(i)
            by_y[y].append(i)

        for group in by_x.values():
            for i in range(1, len(group)):
                union(group[0], group[i])
        for group in by_y.values():
            for i in range(1, len(group)):
                union(group[0], group[i])

        comp_x = defaultdict(set)
        comp_y = defaultdict(set)
        for i, (x, y) in enumerate(points):
            r = find(i)
            comp_x[r].add(x)
            comp_y[r].add(y)

        existing = {(x, y) for x, y in points}
        roots = list(comp_x.keys())
        m = len(roots)
        ans = 1

        for r in roots:
            ans = max(ans, size[r] + 1)

        for i in range(m):
            for j in range(i + 1, m):
                r1, r2 = roots[i], roots[j]
                can_bridge = False
                for x in comp_x[r1]:
                    for y in comp_y[r2]:
                        if (x, y) not in existing:
                            can_bridge = True
                            break
                    if can_bridge:
                        break
                if not can_bridge:
                    for x in comp_x[r2]:
                        for y in comp_y[r1]:
                            if (x, y) not in existing:
                                can_bridge = True
                                break
                        if can_bridge:
                            break
                if can_bridge:
                    ans = max(ans, size[r1] + size[r2] + 1)

        return ans
