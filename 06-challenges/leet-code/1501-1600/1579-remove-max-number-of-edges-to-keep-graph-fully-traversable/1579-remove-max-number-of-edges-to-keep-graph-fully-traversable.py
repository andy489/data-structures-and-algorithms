# https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/

class Solution:
    def maxNumEdgesToRemove(self, n: int, edges: list[list[int]]) -> int:
        parent_a = list(range(n + 1))
        parent_b = list(range(n + 1))
        rank_a = [0] * (n + 1)
        rank_b = [0] * (n + 1)

        def find(parent, x):
            while parent[x] != x:
                parent[x] = parent[parent[x]]
                x = parent[x]
            return x

        def union(parent, rank, a, b):
            ra, rb = find(parent, a), find(parent, b)
            if ra == rb:
                return False
            if rank[ra] < rank[rb]:
                parent[ra] = rb
            elif rank[ra] > rank[rb]:
                parent[rb] = ra
            else:
                parent[rb] = ra
                rank[ra] += 1
            return True

        removed = 0
        conn_a = conn_b = n

        for t, u, v in edges:
            if t == 3:
                ua = union(parent_a, rank_a, u, v)
                ub = union(parent_b, rank_b, u, v)
                if ua:
                    conn_a -= 1
                if ub:
                    conn_b -= 1
                if not ua and not ub:
                    removed += 1

        for t, u, v in edges:
            if t == 1:
                if not union(parent_a, rank_a, u, v):
                    removed += 1
                else:
                    conn_a -= 1
            elif t == 2:
                if not union(parent_b, rank_b, u, v):
                    removed += 1
                else:
                    conn_b -= 1

        return removed if conn_a == 1 and conn_b == 1 else -1
