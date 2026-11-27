# https://leetcode.com/problems/longest-chunked-palindrome-decomposition/

class Solution:
    def longestDecomposition(self, text: str) -> int:
        ans = 0
        l, r = 0, len(text) - 1
        while l <= r:
            found = False
            for length in range(1, (r - l + 2) // 2 + 1):
                if text[l:l + length] == text[r - length + 1:r + 1]:
                    ans += 2
                    l += length
                    r -= length
                    found = True
                    break
            if not found:
                ans += 1
                break
        return ans
