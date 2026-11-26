# https://leetcode.com/problems/maximum-product-of-word-lengths/

class Solution:
    def maxProduct(self, words: list[str]) -> int:
        masks = [0] * len(words)
        for i, w in enumerate(words):
            for c in w:
                masks[i] |= 1 << (ord(c) - 97)
        best = 0
        for i in range(len(words)):
            for j in range(i + 1, len(words)):
                if masks[i] & masks[j] == 0:
                    best = max(best, len(words[i]) * len(words[j]))
        return best
