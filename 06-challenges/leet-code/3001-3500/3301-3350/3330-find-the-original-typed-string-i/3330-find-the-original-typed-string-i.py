# https://leetcode.com/problems/find-the-original-typed-string-i/

class Solution:
    def possibleStringCount(self, word: str) -> int:
        result = 1
        i = 0
        while i < len(word):
            j = i
            while j < len(word) and word[j] == word[i]:
                j += 1
            if j - i > 1:
                result += j - i - 1
            i = j
        return result
