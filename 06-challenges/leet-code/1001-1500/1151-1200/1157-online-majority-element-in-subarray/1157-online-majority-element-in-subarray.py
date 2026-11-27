# https://leetcode.com/problems/online-majority-element-in-subarray/

from bisect import bisect_left, bisect_right
from collections import defaultdict

class MajorityChecker:
    def __init__(self, arr: list[int]):
        self.n = len(arr)
        self.candidate = [0] * (4 * self.n)
        self.count = [0] * (4 * self.n)
        self.positions = defaultdict(list)
        for i, v in enumerate(arr):
            self.positions[v].append(i)
        self._build(arr, 1, 0, self.n - 1)

    def _build(self, arr, node, l, r):
        if l == r:
            self.candidate[node] = arr[l]
            self.count[node] = 1
            return
        mid = (l + r) // 2
        self._build(arr, 2 * node, l, mid)
        self._build(arr, 2 * node + 1, mid + 1, r)
        self._merge(node)

    def _merge(self, node):
        lc, rc = self.candidate[2 * node], self.candidate[2 * node + 1]
        lv, rv = self.count[2 * node], self.count[2 * node + 1]
        if lc == rc:
            self.candidate[node], self.count[node] = lc, lv + rv
        elif lv >= rv:
            self.candidate[node], self.count[node] = lc, lv - rv
        else:
            self.candidate[node], self.count[node] = rc, rv - lv

    def _query(self, node, l, r, ql, qr):
        if ql <= l and r <= qr:
            return self.candidate[node], self.count[node]
        mid = (l + r) // 2
        if qr <= mid:
            return self._query(2 * node, l, mid, ql, qr)
        if ql > mid:
            return self._query(2 * node + 1, mid + 1, r, ql, qr)
        lc, lv = self._query(2 * node, l, mid, ql, qr)
        rc, rv = self._query(2 * node + 1, mid + 1, r, ql, qr)
        if lc == rc:
            return lc, lv + rv
        elif lv >= rv:
            return lc, lv - rv
        else:
            return rc, rv - lv

    def query(self, left: int, right: int, threshold: int) -> int:
        cand, _ = self._query(1, 0, self.n - 1, left, right)
        pos = self.positions[cand]
        lo = bisect_left(pos, left)
        hi = bisect_right(pos, right)
        return cand if hi - lo >= threshold else -1
