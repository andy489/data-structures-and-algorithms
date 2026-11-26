# https://leetcode.com/problems/detect-squares/

class DetectSquares:
    def __init__(self):
        from collections import defaultdict
        self.row = defaultdict(lambda: defaultdict(int))
        self.pts = defaultdict(int)

    def add(self, point: list[int]) -> None:
        x, y = point
        self.row[y][x] += 1
        self.pts[(x, y)] += 1

    def count(self, point: list[int]) -> int:
        px, py = point
        res = 0
        for x1, cnt in self.row[py].items():
            if x1 == px:
                continue
            side = abs(x1 - px)
            for ny in [py + side, py - side]:
                res += cnt * self.pts[(px, ny)] * self.pts[(x1, ny)]
        return res
