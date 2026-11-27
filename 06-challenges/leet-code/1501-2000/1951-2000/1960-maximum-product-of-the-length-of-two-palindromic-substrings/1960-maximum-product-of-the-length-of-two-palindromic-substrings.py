# https://leetcode.com/problems/maximum-product-of-the-length-of-two-palindromic-substrings/
class Solution:
    def maxProduct(self, s: str) -> int:
        n = len(s)
        p = self.manacher(s)

        left = [1] * n
        for i in range(n):
            r = p[i]
            end = i + r
            if end < n:
                left[end] = max(left[end], 2 * r + 1)
        for i in range(1, n):
            left[i] = max(left[i], left[i - 1])

        right = [1] * n
        for i in range(n):
            r = p[i]
            start = i - r
            right[start] = max(right[start], 2 * r + 1)
        for i in range(n - 2, -1, -1):
            right[i] = max(right[i], right[i + 1])

        ans = 0
        for i in range(n - 1):
            ans = max(ans, left[i] * right[i + 1])
        return ans

    def manacher(self, s: str) -> list[int]:
        n = len(s)
        p = [0] * n
        c = r = 0
        for i in range(n):
            if i < r:
                p[i] = min(r - i, p[2 * c - i])
            while i - p[i] - 1 >= 0 and i + p[i] + 1 < n and s[i - p[i] - 1] == s[i + p[i] + 1]:
                p[i] += 1
            if i + p[i] > r:
                c, r = i, i + p[i]
        return p
