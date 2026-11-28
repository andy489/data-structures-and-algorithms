# https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string/

class Solution:
    def shortestBeautifulSubstring(self, s: str, k: int) -> str:
        n = len(s)
        result = ""
        min_len = n + 1
        left = 0
        ones = 0

        for right in range(n):
            if s[right] == '1':
                ones += 1
            while ones == k:
                sub = s[left:right + 1]
                length = right - left + 1
                if length < min_len or (length == min_len and sub < result):
                    min_len = length
                    result = sub
                if s[left] == '1':
                    ones -= 1
                left += 1

        return result
