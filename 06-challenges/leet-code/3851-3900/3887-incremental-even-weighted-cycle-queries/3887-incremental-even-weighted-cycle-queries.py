# https://leetcode.com/problems/incremental-even-weighted-cycle-queries/
class Solution:
    def incrementalEvenWeightedCycleQueries(self, n: int, edges: list[list[int]]) -> int:
        parent = list(range(n))
        rank = [0] * n
        parity = [0] * n  # parity[i] = XOR parity from i to its root

        def find(x: int) -> tuple[int, int]:
            if parent[x] != x:
                root, par = find(parent[x])
                parity[x] ^= parity[parent[x]]
                parent[x] = root
            return parent[x], parity[x]

        count = 0
        for u, v, w in edges:
            root_u, par_u = find(u)
            root_v, par_v = find(v)

            if root_u != root_v:
                if rank[root_u] < rank[root_v]:
                    parent[root_u] = root_v
                    parity[root_u] = par_u ^ par_v ^ w
                elif rank[root_u] > rank[root_v]:
                    parent[root_v] = root_u
                    parity[root_v] = par_u ^ par_v ^ w
                else:
                    parent[root_v] = root_u
                    parity[root_v] = par_u ^ par_v ^ w
                    rank[root_u] += 1
                count += 1
            else:
                if (par_u ^ par_v) == (w % 2):
                    count += 1

        return count
