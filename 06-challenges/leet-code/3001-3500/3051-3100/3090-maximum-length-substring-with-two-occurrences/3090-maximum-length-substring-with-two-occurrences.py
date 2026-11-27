# https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/

class Solution:
    def maximumLengthSubstring(self, s: str) -> int:
        from collections import defaultdict
        freq = defaultdict(int)
        l = max_len = 0
        for r, ch in enumerate(s):
            freq[ch] += 1
            while freq[ch] > 2:
                freq[s[l]] -= 1
                l += 1
            max_len = max(max_len, r - l + 1)
        return max_len
