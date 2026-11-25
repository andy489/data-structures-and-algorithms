# https://leetcode.com/problems/find-common-characters/

class Solution:
    def commonChars(self, words: list[str]) -> list[str]:
        from collections import Counter
        min_freq = Counter(words[0])
        for word in words[1:]:
            min_freq &= Counter(word)
        return list(min_freq.elements())
