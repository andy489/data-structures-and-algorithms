# https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/

class Solution:
    def longestSubstring(self, s: str, k: int) -> int:
        def solve(l: int, r: int) -> int:
            if r - l + 1 < k:
                return 0
            freq = [0] * 26
            for i in range(l, r + 1):
                freq[ord(s[i]) - ord('a')] += 1
            for i in range(l, r + 1):
                if freq[ord(s[i]) - ord('a')] < k:
                    return max(solve(l, i - 1), solve(i + 1, r))
            return r - l + 1
        return solve(0, len(s) - 1)
