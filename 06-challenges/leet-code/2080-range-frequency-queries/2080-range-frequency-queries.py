# https://leetcode.com/problems/range-frequency-queries/

class RangeFreqQuery:
    def __init__(self, arr: list[int]):
        import bisect
        from collections import defaultdict
        self.indices = defaultdict(list)
        for i, x in enumerate(arr):
            self.indices[x].append(i)
        self._bisect = bisect

    def query(self, left: int, right: int, value: int) -> int:
        lst = self.indices.get(value, [])
        lo = self._bisect.bisect_left(lst, left)
        hi = self._bisect.bisect_right(lst, right)
        return hi - lo
