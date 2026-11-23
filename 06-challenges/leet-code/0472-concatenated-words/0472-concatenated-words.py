# https://leetcode.com/problems/concatenated-words/

class Solution:
    def findAllConcatenatedWordsInADict(self, words: list[str]) -> list[str]:
        word_set = set()
        result = []
        words.sort(key=len)

        for word in words:
            if word and self._can_form(word, word_set):
                result.append(word)
            word_set.add(word)
        return result

    def _can_form(self, word: str, word_set: set) -> bool:
        if not word_set:
            return False
        n = len(word)
        reachable = [False] * (n + 1)
        reachable[0] = True
        for i in range(1, n + 1):
            for j in range(i):
                if reachable[j] and word[j:i] in word_set:
                    reachable[i] = True
                    break
        return reachable[n]
