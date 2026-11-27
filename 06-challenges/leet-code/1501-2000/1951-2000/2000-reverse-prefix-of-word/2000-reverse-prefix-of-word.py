# https://leetcode.com/problems/reverse-prefix-of-word/

class Solution:
    def reversePrefix(self, word: str, ch: str) -> str:
        i = word.find(ch)
        if i == -1:
            return word
        return word[:i+1][::-1] + word[i+1:]
