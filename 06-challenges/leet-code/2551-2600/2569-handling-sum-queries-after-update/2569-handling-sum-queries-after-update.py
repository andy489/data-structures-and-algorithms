# https://leetcode.com/problems/handling-sum-queries-after-update/

# Solution: Segment Tree with Lazy Propagation — O((n+q) log n) time
class Solution:
    def handleQuery(self, nums1: list[int], nums2: list[int], queries: list[list[int]]) -> list[int]:
        n = len(nums1)
        tree = [0] * (4 * n)
        lazy = [False] * (4 * n)

        def build(node: int, l: int, r: int) -> None:
            if l == r:
                tree[node] = nums1[l]
                return
            mid = (l + r) // 2
            build(2 * node, l, mid)
            build(2 * node + 1, mid + 1, r)
            tree[node] = tree[2 * node] + tree[2 * node + 1]

        def push_down(node: int, l: int, r: int) -> None:
            if lazy[node]:
                mid = (l + r) // 2
                tree[2 * node] = (mid - l + 1) - tree[2 * node]
                tree[2 * node + 1] = (r - mid) - tree[2 * node + 1]
                lazy[2 * node] = not lazy[2 * node]
                lazy[2 * node + 1] = not lazy[2 * node + 1]
                lazy[node] = False

        def flip(node: int, l: int, r: int, ql: int, qr: int) -> None:
            if ql <= l and r <= qr:
                tree[node] = (r - l + 1) - tree[node]
                lazy[node] = not lazy[node]
                return
            push_down(node, l, r)
            mid = (l + r) // 2
            if ql <= mid:
                flip(2 * node, l, mid, ql, qr)
            if qr > mid:
                flip(2 * node + 1, mid + 1, r, ql, qr)
            tree[node] = tree[2 * node] + tree[2 * node + 1]

        build(1, 0, n - 1)
        sum2 = sum(nums2)
        result = []
        for q in queries:
            if q[0] == 1:
                flip(1, 0, n - 1, q[1], q[2])
            elif q[0] == 2:
                sum2 += tree[1] * q[1]
            else:
                result.append(sum2)
        return result
