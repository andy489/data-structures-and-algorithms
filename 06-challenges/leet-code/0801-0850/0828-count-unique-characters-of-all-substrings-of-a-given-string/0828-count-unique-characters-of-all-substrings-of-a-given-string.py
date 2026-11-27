# https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/

class Solution:
    def uniqueLetterString(self, s: str) -> int:
        last = {c: [-1, -1] for c in 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'}
        total = 0
        for i, ch in enumerate(s):
            prev2, prev1 = last[ch]
            total += (i - prev1) * (prev1 - prev2)
            last[ch] = [prev1, i]
        n = len(s)
        for ch, (prev2, prev1) in last.items():
            total += (n - prev1) * (prev1 - prev2)
        return total
