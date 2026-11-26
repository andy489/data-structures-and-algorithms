# https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/

class Solution:
    def findTheLongestSubstring(self, s: str) -> int:
        vowel_bit = {'a':0,'e':1,'i':2,'o':3,'u':4}
        first = {0: -1}
        mask = ans = 0
        for i, c in enumerate(s):
            if c in vowel_bit:
                mask ^= 1 << vowel_bit[c]
            if mask not in first:
                first[mask] = i
            else:
                ans = max(ans, i - first[mask])
        return ans
