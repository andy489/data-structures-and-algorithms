# https://leetcode.com/problems/palindrome-rearrangement-queries/
class Solution:
    def canMakePalindromeQueries(self, s: str, queries: list[list[int]]) -> list[bool]:
        n = len(s)
        half = n // 2

        # Build prefix frequency arrays for left and right halves
        pref_l = [[0] * 26 for _ in range(half + 1)]
        pref_r = [[0] * 26 for _ in range(half + 1)]
        for i in range(half):
            pref_l[i + 1] = pref_l[i][:]
            pref_l[i + 1][ord(s[i]) - ord('a')] += 1
            pref_r[i + 1] = pref_r[i][:]
            pref_r[i + 1][ord(s[n - 1 - i]) - ord('a')] += 1

        # Prefix mismatch count
        mismatch = [0] * (half + 1)
        for i in range(half):
            mismatch[i + 1] = mismatch[i] + (1 if s[i] != s[n - 1 - i] else 0)

        def range_count(pref, l, r):
            return [pref[r + 1][c] - pref[l][c] for c in range(26)]

        result = []
        for a, b, c, d in queries:
            cl, dl = n - 1 - d, n - 1 - c
            lo, hi = min(a, cl), max(b, dl)
            # Mismatches outside the union window
            outside = mismatch[lo] + mismatch[half] - mismatch[hi + 1]
            if outside > 0:
                result.append(False)
                continue
            cnt_l = range_count(pref_l, a, b)
            cnt_r = range_count(pref_r, cl, dl)
            result.append(cnt_l == cnt_r)
        return result
