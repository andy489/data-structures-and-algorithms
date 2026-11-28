# https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-ii/

class Solution:
    def sumCounts(self, nums: list[int]) -> int:
        MOD = 10**9 + 7
        n = len(nums)

        sum_sq = [0] * (4 * n)
        sum_d = [0] * (4 * n)
        lazy = [0] * (4 * n)
        cnt = [0] * (4 * n)

        def build(node, l, r):
            cnt[node] = r - l + 1
            if l == r:
                return
            mid = (l + r) // 2
            build(2 * node, l, mid)
            build(2 * node + 1, mid + 1, r)

        def push_down(node):
            lz = lazy[node]
            if lz == 0:
                return
            for child in (2 * node, 2 * node + 1):
                c = cnt[child]
                sum_sq[child] = (sum_sq[child] + 2 * lz * sum_d[child] + lz * lz * c) % MOD
                sum_d[child] = (sum_d[child] + lz * c) % MOD
                lazy[child] = (lazy[child] + lz) % MOD
            lazy[node] = 0

        def update(node, l, r, ql, qr):
            if qr < l or r < ql:
                return
            if ql <= l <= r <= qr:
                c = cnt[node]
                sum_sq[node] = (sum_sq[node] + 2 * sum_d[node] + c) % MOD
                sum_d[node] = (sum_d[node] + c) % MOD
                lazy[node] = (lazy[node] + 1) % MOD
                return
            push_down(node)
            mid = (l + r) // 2
            update(2 * node, l, mid, ql, qr)
            update(2 * node + 1, mid + 1, r, ql, qr)
            sum_sq[node] = (sum_sq[2 * node] + sum_sq[2 * node + 1]) % MOD
            sum_d[node] = (sum_d[2 * node] + sum_d[2 * node + 1]) % MOD

        def query(node, l, r, ql, qr):
            if qr < l or r < ql:
                return 0
            if ql <= l <= r <= qr:
                return sum_sq[node]
            push_down(node)
            mid = (l + r) // 2
            return (query(2 * node, l, mid, ql, qr) + query(2 * node + 1, mid + 1, r, ql, qr)) % MOD

        build(1, 0, n - 1)
        last_seen = {}
        ans = 0

        for i, x in enumerate(nums):
            prev = last_seen.get(x, -1)
            update(1, 0, n - 1, prev + 1, i)
            ans = (ans + query(1, 0, n - 1, 0, i)) % MOD
            last_seen[x] = i

        return ans
