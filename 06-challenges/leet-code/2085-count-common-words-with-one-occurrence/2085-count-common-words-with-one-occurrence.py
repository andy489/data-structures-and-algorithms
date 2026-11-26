# https://leetcode.com/problems/count-common-words-with-one-occurrence/

class Solution:
    def countWords(self, words1: list[str], words2: list[str]) -> int:
        from collections import Counter
        c1, c2 = Counter(words1), Counter(words2)
        return sum(1 for w in c1 if c1[w] == 1 and c2[w] == 1)
