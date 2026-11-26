# https://leetcode.com/problems/maximum-score-words-formed-by-letters/

class Solution:
    def maxScoreWords(self, words: list[str], letters: list[str], score: list[int]) -> int:
        from collections import Counter
        avail = Counter(letters)
        res = 0
        for mask in range(1 << len(words)):
            need = Counter()
            s = 0
            for i, w in enumerate(words):
                if mask >> i & 1:
                    need.update(w)
                    s += sum(score[ord(c)-ord('a')] for c in w)
            if all(need[c] <= avail[c] for c in need):
                res = max(res, s)
        return res
