# https://leetcode.com/problems/sum-of-beauty-of-all-substrings/

class Solution:
    def beautySum(self, s: str) -> int:
        n = len(s)
        result = 0
        for i in range(n):
            freq = [0] * 26
            for j in range(i, n):
                freq[ord(s[j]) - ord('a')] += 1
                nonzero = [f for f in freq if f > 0]
                result += max(nonzero) - min(nonzero)
        return result
