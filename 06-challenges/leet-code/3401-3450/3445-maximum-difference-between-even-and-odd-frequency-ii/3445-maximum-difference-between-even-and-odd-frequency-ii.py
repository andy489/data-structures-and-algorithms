# https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-ii/
class Solution:
    def maxDifference(self, s: str, k: int) -> int:
        n = len(s)
        res = float('-inf')
        INF = float('inf')

        for a in range(5):
            for b in range(5):
                if a == b:
                    continue
                pref_a = [0] * (n + 1)
                pref_b = [0] * (n + 1)
                for i, c in enumerate(s):
                    d = int(c)
                    pref_a[i + 1] = pref_a[i] + (1 if d == a else 0)
                    pref_b[i + 1] = pref_b[i] + (1 if d == b else 0)

                best = [[INF, INF], [INF, INF]]
                for r in range(k, n + 1):
                    l = r - k
                    pa_l = pref_a[l] % 2
                    pb_l = pref_b[l] % 2
                    if pref_b[l] < pref_b[r]:
                        val = pref_a[l] - pref_b[l]
                        if val < best[pa_l][pb_l]:
                            best[pa_l][pb_l] = val
                    pa_r = pref_a[r] % 2
                    pb_r = pref_b[r] % 2
                    needed_pa = 1 - pa_r
                    needed_pb = pb_r
                    bv = best[needed_pa][needed_pb]
                    if bv < INF:
                        candidate = (pref_a[r] - pref_b[r]) - bv
                        if candidate > res:
                            res = candidate

        return res
