# https://leetcode.com/problems/merge-close-characters/

class Solution:
    def mergeCloseCharacters(self, s: str, k: int) -> str:
        chars = list(s)
        merged = True
        while merged:
            merged = False
            for i in range(len(chars)):
                for j in range(i + 1, min(i + k + 1, len(chars))):
                    if chars[i] == chars[j]:
                        chars.pop(j)
                        merged = True
                        break
                if merged:
                    break
        return ''.join(chars)
