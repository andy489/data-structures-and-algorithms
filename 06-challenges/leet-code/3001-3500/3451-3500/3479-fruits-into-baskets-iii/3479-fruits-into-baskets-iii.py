# https://leetcode.com/problems/fruits-into-baskets-iii/

class Solution:
    def numOfUnplacedFruits(self, fruits: list[int], baskets: list[int]) -> int:
        n = len(baskets)
        tree = [0] * (4 * n)

        def build(node, lo, hi):
            if lo == hi:
                tree[node] = baskets[lo]
                return
            mid = (lo + hi) // 2
            build(2 * node, lo, mid)
            build(2 * node + 1, mid + 1, hi)
            tree[node] = max(tree[2 * node], tree[2 * node + 1])

        def query(node, lo, hi, need):
            if lo == hi:
                return lo
            mid = (lo + hi) // 2
            if tree[2 * node] >= need:
                return query(2 * node, lo, mid, need)
            return query(2 * node + 1, mid + 1, hi, need)

        def update(node, lo, hi, pos):
            if lo == hi:
                tree[node] = 0
                return
            mid = (lo + hi) // 2
            if pos <= mid:
                update(2 * node, lo, mid, pos)
            else:
                update(2 * node + 1, mid + 1, hi, pos)
            tree[node] = max(tree[2 * node], tree[2 * node + 1])

        build(1, 0, n - 1)
        unplaced = 0
        for f in fruits:
            if tree[1] < f:
                unplaced += 1
            else:
                idx = query(1, 0, n - 1, f)
                update(1, 0, n - 1, idx)
        return unplaced
