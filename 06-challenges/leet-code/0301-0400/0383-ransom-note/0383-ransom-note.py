# https://leetcode.com/problems/ransom-note/

class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        count = [0] * 26
        for c in magazine:
            count[ord(c) - 97] += 1
        for c in ransomNote:
            count[ord(c) - 97] -= 1
            if count[ord(c) - 97] < 0:
                return False
        return True
