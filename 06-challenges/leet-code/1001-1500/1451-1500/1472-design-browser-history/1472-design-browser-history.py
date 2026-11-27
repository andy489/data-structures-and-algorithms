# https://leetcode.com/problems/design-browser-history/

class BrowserHistory:
    def __init__(self, homepage: str):
        self.hist = [homepage]
        self.curr = 0
    def visit(self, url: str) -> None:
        del self.hist[self.curr+1:]
        self.hist.append(url)
        self.curr += 1
    def back(self, steps: int) -> str:
        self.curr = max(0, self.curr - steps)
        return self.hist[self.curr]
    def forward(self, steps: int) -> str:
        self.curr = min(len(self.hist)-1, self.curr+steps)
        return self.hist[self.curr]
