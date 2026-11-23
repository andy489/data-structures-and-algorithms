# https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/

class Solution:
    def findLongestWord(self, s: str, dictionary: list[str]) -> str:
        def is_subseq(word: str) -> bool:
            it = iter(s)
            return all(c in it for c in word)

        result = ""
        for word in dictionary:
            if is_subseq(word):
                if len(word) > len(result) or (len(word) == len(result) and word < result):
                    result = word
        return result
