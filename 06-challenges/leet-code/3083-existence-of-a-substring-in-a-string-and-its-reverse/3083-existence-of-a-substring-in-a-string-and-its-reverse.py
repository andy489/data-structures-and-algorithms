# https://leetcode.com/problems/existence-of-a-substring-in-a-string-and-its-reverse/

class Solution:
    def isSubstringPresent(self, s: str) -> bool:
        pairs = {s[i:i+2] for i in range(len(s)-1)}
        return any(s[i+1]+s[i] in pairs for i in range(len(s)-1))
