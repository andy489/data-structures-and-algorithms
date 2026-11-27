# https://leetcode.com/problems/sentence-similarity-iii/

class Solution:
    def areSentencesSimilar(self, sentence1: str, sentence2: str) -> bool:
        w1, w2 = sentence1.split(), sentence2.split()
        i, j1, j2 = 0, len(w1) - 1, len(w2) - 1
        while i <= j1 and i <= j2 and w1[i] == w2[i]:
            i += 1
        while j1 >= i and j2 >= i and w1[j1] == w2[j2]:
            j1 -= 1
            j2 -= 1
        return i > j1 or i > j2
