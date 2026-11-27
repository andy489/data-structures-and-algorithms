# https://leetcode.com/problems/minimum-moves-to-capture-the-queen/

class Solution:
    def minMovesToCaptureTheQueen(self, a: int, b: int, c: int, d: int, e: int, f: int) -> int:
        # Rook same row
        if a == e and (c != a or not (min(b,f) < d < max(b,f))): return 1
        # Rook same col
        if b == f and (d != b or not (min(a,e) < c < max(a,e))): return 1
        # Bishop same diagonal
        if abs(c-e) == abs(d-f):
            if not (min(c,e) < a < max(c,e) and min(d,f) < b < max(d,f)): return 1
        return 2
