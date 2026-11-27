# https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/

class Solution:
    def numberOfSubstrings(self, s: str) -> int:
        last = [-1, -1, -1]
        count = 0
        for i, c in enumerate(s):
            last[ord(c)-ord('a')] = i
            count += 1 + min(last)
        return count
