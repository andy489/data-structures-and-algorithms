# https://leetcode.com/problems/first-unique-character-in-a-string/

class Solution:
    def firstUniqChar(self, s: str) -> int:
        count = [0] * 26
        for c in s:
            count[ord(c) - 97] += 1
        for i, c in enumerate(s):
            if count[ord(c) - 97] == 1:
                return i
        return -1
