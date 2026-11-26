# https://leetcode.com/problems/plates-between-candles/

class Solution:
    def platesBetweenCandles(self, s: str, queries: list[list[int]]) -> list[int]:
        import bisect
        n = len(s)
        prefix = [0] * (n + 1)
        candles = []
        for i, c in enumerate(s):
            prefix[i+1] = prefix[i] + (1 if c == '*' else 0)
            if c == '|':
                candles.append(i)
        res = []
        for l, r in queries:
            cl = bisect.bisect_left(candles, l)
            cr = bisect.bisect_right(candles, r) - 1
            if cl <= cr:
                res.append(prefix[candles[cr]+1] - prefix[candles[cl]])
            else:
                res.append(0)
        return res
