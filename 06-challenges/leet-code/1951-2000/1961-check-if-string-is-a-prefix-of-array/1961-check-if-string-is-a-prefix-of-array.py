# https://leetcode.com/problems/check-if-string-is-a-prefix-of-array/
class Solution:
    def isPrefixString(self, s: str, words: list[str]) -> bool:
        built = ''
        for word in words:
            built += word
            if built == s:
                return True
            if len(built) > len(s):
                return False
        return False
