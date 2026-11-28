# https://leetcode.com/problems/count-beautiful-substrings-ii/

from collections import defaultdict

class Solution:
    def beautifulSubstrings(self, s: str, k: int) -> int:
        p = 1
        while (p * p) % k != 0:
            p += 1
        period = 2 * p

        vowels = set('aeiou')
        n = len(s)
        count = 0
        pre = 0
        freq = defaultdict(int)
        freq[(0, 0)] = 1

        for j in range(n):
            pre += 1 if s[j] in vowels else -1
            key = (pre, (j + 1) % period)
            count += freq[key]
            freq[key] += 1

        return count
