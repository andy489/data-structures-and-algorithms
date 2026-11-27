# https://leetcode.com/problems/find-the-occurrence-of-first-almost-equal-substring/


def z_function(t: str):
    n = len(t)
    z = [0] * n
    z[0] = n
    l = r = 0
    for i in range(1, n):
        if i < r:
            z[i] = min(r - i, z[i - l])
        while i + z[i] < n and t[z[i]] == t[i + z[i]]:
            z[i] += 1
        if i + z[i] > r:
            l, r = i, i + z[i]
    return z


class Solution:
    def minStartingIndex(self, s: str, pattern: str) -> int:
        n, m = len(s), len(pattern)
        z_pre = z_function(pattern + "#" + s)
        z_suf = z_function(pattern[::-1] + "#" + s[::-1])
        for i in range(n - m + 1):
            pre = min(z_pre[m + 1 + i], m)
            suf = min(z_suf[m + 1 + (n - m - i)], m)
            if pre + suf >= m - 1:
                return i
        return -1
