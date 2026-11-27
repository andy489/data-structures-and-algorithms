# https://leetcode.com/problems/count-substrings-with-k-frequency-characters-i/

class Solution:
    def numberOfSubstrings(self, s: str, k: int) -> int:
        n = len(s)
        result = 0
        freq = [0] * 26
        left = 0
        for right in range(n):
            freq[ord(s[right]) - ord('a')] += 1
            while freq[ord(s[right]) - ord('a')] >= k:
                result += n - right
                freq[ord(s[left]) - ord('a')] -= 1
                left += 1
        return result
