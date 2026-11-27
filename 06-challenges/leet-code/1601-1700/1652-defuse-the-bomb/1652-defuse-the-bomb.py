# https://leetcode.com/problems/defuse-the-bomb/

class Solution:
    def decrypt(self, code: list[int], k: int) -> list[int]:
        n = len(code)
        if k == 0:
            return [0] * n
        doubled = code + code
        prefix = [0] * (2 * n + 1)
        for i in range(2 * n):
            prefix[i + 1] = prefix[i] + doubled[i]
        result = []
        for i in range(n):
            if k > 0:
                lo, hi = i + 1, i + k
            else:
                lo, hi = i - (-k) + n, i - 1 + n
            result.append(prefix[hi + 1] - prefix[lo])
        return result
