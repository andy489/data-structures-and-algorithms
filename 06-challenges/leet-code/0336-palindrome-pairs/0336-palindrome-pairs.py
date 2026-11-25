# https://leetcode.com/problems/palindrome-pairs/

class Solution:
    def palindromePairs(self, words: list[str]) -> list[list[int]]:
        word_idx = {w: i for i, w in enumerate(words)}
        result = []
        def is_palin(s): return s == s[::-1]
        for i, w in enumerate(words):
            for k in range(len(w) + 1):
                prefix, suffix = w[:k], w[k:]
                if is_palin(prefix):
                    j = word_idx.get(suffix[::-1])
                    if j is not None and j != i:
                        result.append([j, i])
                if k != len(w) and is_palin(suffix):
                    j = word_idx.get(prefix[::-1])
                    if j is not None and j != i:
                        result.append([i, j])
        return result
