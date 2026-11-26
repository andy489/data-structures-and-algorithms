# https://leetcode.com/problems/print-words-vertically/

class Solution:
    def printVertically(self, s: str) -> list[str]:
        words = s.split()
        max_len = max(len(w) for w in words)
        return [''.join(w[i] if i < len(w) else ' ' for w in words).rstrip()
                for i in range(max_len)]
