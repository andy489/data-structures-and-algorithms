# https://leetcode.com/problems/find-the-string-with-lcp/

from typing import List

class Solution:
    def findTheString(self, lcp: List[List[int]]) -> str:
        n = len(lcp)
        word = [''] * n

        # Greedy: assign smallest available character
        next_char = 0
        for i in range(n):
            if word[i]:
                continue
            if next_char >= 26:
                return ""
            word[i] = chr(ord('a') + next_char)
            next_char += 1
            for j in range(i + 1, n):
                if lcp[i][j] > 0:
                    if word[j] and word[j] != word[i]:
                        return ""
                    word[j] = word[i]

        # Validate by computing actual LCP matrix
        actual = [[0] * (n + 1) for _ in range(n + 1)]
        for i in range(n - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                if word[i] == word[j]:
                    actual[i][j] = actual[i + 1][j + 1] + 1
                else:
                    actual[i][j] = 0
                if actual[i][j] != lcp[i][j]:
                    return ""

        return ''.join(word)
