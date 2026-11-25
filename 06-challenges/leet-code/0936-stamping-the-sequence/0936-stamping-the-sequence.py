# https://leetcode.com/problems/stamping-the-sequence/

class Solution:
    def movesToStamp(self, stamp: str, target: str) -> list:
        t = list(target)
        s = list(stamp)
        n, m = len(t), len(s)
        result = []
        stars = 0

        def try_stamp(i):
            covered = 0
            for j in range(m):
                if t[i+j] == '?':
                    continue
                if t[i+j] != s[j]:
                    return 0
                covered += 1
            return covered

        while stars < n:
            progress = False
            for i in range(n - m + 1):
                c = try_stamp(i)
                if c > 0:
                    stars += c
                    progress = True
                    result.append(i)
                    for j in range(i, i + m):
                        t[j] = '?'
            if not progress:
                return []
        return result[::-1]
