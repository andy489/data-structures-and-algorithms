# https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        last_seen = {}
        lo = 0
        max_len = 0

        for hi, c in enumerate(s):
            if c in last_seen and last_seen[c] >= lo:
                lo = last_seen[c] + 1
            last_seen[c] = hi
            max_len = max(max_len, hi - lo + 1)

        return max_len
