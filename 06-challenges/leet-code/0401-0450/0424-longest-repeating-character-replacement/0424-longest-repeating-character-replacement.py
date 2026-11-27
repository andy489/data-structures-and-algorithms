# https://leetcode.com/problems/longest-repeating-character-replacement/

class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        char_freq = [0] * 26
        left = 0
        max_freq = 0

        for right in range(len(s)):
            char_freq[ord(s[right]) - ord('A')] += 1
            max_freq = max(max_freq, char_freq[ord(s[right]) - ord('A')])
            if (right - left + 1) - max_freq > k:
                char_freq[ord(s[left]) - ord('A')] -= 1
                left += 1

        return len(s) - left
