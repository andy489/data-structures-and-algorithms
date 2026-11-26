# https://leetcode.com/problems/minimum-window-substring/

from collections import Counter

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(s) < len(t):
            return ""
        need = Counter(t)
        window = {}
        required, formed = len(need), 0
        left = 0
        min_len, min_left = float("inf"), 0
        for right, c in enumerate(s):
            window[c] = window.get(c, 0) + 1
            if c in need and window[c] == need[c]:
                formed += 1
            while formed == required:
                if right - left + 1 < min_len:
                    min_len = right - left + 1
                    min_left = left
                lc = s[left]
                left += 1
                window[lc] -= 1
                if lc in need and window[lc] < need[lc]:
                    formed -= 1
        return "" if min_len == float("inf") else s[min_left:min_left + min_len]
