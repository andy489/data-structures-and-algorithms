# https://leetcode.com/problems/count-sorted-vowel-strings/

class Solution:
    def countVowelStrings(self, n: int) -> int:
        # C(n+4, 4)
        return (n + 1) * (n + 2) * (n + 3) * (n + 4) // 24
