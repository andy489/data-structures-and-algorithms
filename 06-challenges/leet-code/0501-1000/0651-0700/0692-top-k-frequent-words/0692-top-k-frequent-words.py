# https://leetcode.com/problems/top-k-frequent-words/

from collections import Counter

class Solution:
    def topKFrequent(self, words: list, k: int) -> list:
        freq = Counter(words)
        return sorted(freq.keys(), key=lambda w: (-freq[w], w))[:k]
