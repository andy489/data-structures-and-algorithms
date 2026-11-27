# https://leetcode.com/problems/substring-xor-queries/

# Solution: Precompute Substring Values (up to 32 bits) — O(32n + q) time
class Solution:
    def substringXorQueries(self, s: str, queries: list[list[int]]) -> list[list[int]]:
        first_occurrence = {}
        n = len(s)
        for l in range(n):
            if s[l] == '0':
                if 0 not in first_occurrence:
                    first_occurrence[0] = [l, l]
                continue
            val = 0
            for r in range(l, min(l + 32, n)):
                val = (val << 1) | int(s[r])
                if val not in first_occurrence:
                    first_occurrence[val] = [l, r]
        return [first_occurrence.get(a ^ b, [-1, -1]) for a, b in queries]
