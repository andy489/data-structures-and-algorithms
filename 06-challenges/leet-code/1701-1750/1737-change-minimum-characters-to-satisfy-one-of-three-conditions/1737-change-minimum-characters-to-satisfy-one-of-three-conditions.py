# https://leetcode.com/problems/change-minimum-characters-to-satisfy-one-of-three-conditions/

class Solution:
    def minCharacters(self, a: str, b: str) -> int:
        fa = [0] * 26
        fb = [0] * 26
        for c in a:
            fa[ord(c) - 97] += 1
        for c in b:
            fb[ord(c) - 97] += 1
        na, nb = len(a), len(b)
        ans = na + nb

        # Condition 3
        for i in range(26):
            ans = min(ans, (na - fa[i]) + (nb - fb[i]))

        # Prefix sums
        pref_a = fa[:]
        pref_b = fb[:]
        for i in range(1, 26):
            pref_a[i] += pref_a[i - 1]
            pref_b[i] += pref_b[i - 1]

        # Conditions 1 & 2
        for c in range(1, 26):
            ans = min(ans, (na - pref_a[c - 1]) + pref_b[c - 1])
            ans = min(ans, (nb - pref_b[c - 1]) + pref_a[c - 1])
        return ans
