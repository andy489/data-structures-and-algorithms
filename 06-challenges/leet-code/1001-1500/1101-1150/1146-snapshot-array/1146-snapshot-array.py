# https://leetcode.com/problems/snapshot-array/

import bisect

class SnapshotArray:
    def __init__(self, length: int):
        self.history = [[[0, 0]] for _ in range(length)]
        self.snap_id = 0

    def set(self, index: int, val: int) -> None:
        h = self.history[index]
        if h[-1][0] == self.snap_id:
            h[-1][1] = val
        else:
            h.append([self.snap_id, val])

    def snap(self) -> int:
        self.snap_id += 1
        return self.snap_id - 1

    def get(self, index: int, snap_id: int) -> int:
        h = self.history[index]
        # Find rightmost entry with snap_id <= snap_id
        keys = [entry[0] for entry in h]
        pos = bisect.bisect_right(keys, snap_id) - 1
        return h[pos][1]
