# https://leetcode.com/problems/count-valid-word-occurrences/

from collections import defaultdict

class Solution:
    def countValidWordOccurrences(self, chunks: list[str], queries: list[str]) -> list[int]:
        s = ''.join(chunks)
        n = len(s)
        freq = defaultdict(int)
        start = -1
        for i in range(n + 1):
            ch = s[i] if i < n else ' '
            if i < n and ch.islower():
                if start == -1:
                    start = i
            elif i < n and ch == '-':
                if start == -1 or i + 1 >= n or not s[i + 1].islower():
                    if start != -1:
                        freq[s[start:i]] += 1
                        start = -1
                # else joiner hyphen, continue
            else:
                if start != -1:
                    freq[s[start:i]] += 1
                    start = -1
        return [freq[q] for q in queries]
