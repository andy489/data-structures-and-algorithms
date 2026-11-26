# https://leetcode.com/problems/walking-robot-simulation-ii/

class Robot:
    DIR_NAMES = ["East", "North", "West", "South"]

    def __init__(self, width: int, height: int):
        self.w = width
        self.h = height
        self.perim = 2 * (width + height - 2)
        self.pos = 0

    def step(self, num: int) -> None:
        self.pos = (self.pos + num) % self.perim

    def _get_state(self):
        p, w, h = self.pos, self.w, self.h
        if p < w:
            return p, 0, 0
        elif p < w + h - 1:
            return w - 1, p - w + 1, 1
        elif p < 2 * w + h - 2:
            return w - 1 - (p - w - h + 2), h - 1, 2
        else:
            return 0, h - 1 - (p - 2 * w - h + 3), 3

    def getPos(self) -> list[int]:
        x, y, _ = self._get_state()
        return [x, y]

    def getDir(self) -> str:
        _, _, d = self._get_state()
        return self.DIR_NAMES[d]
