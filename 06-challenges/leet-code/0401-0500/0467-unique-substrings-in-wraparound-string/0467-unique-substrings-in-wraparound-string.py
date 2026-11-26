# https://leetcode.com/problems/unique-substrings-in-wraparound-string/

class Solution:
    def findSubstringInWraproundString(self, p: str) -> int:
        max_len_ending_at = [0] * 26
        cur_len = 0
        for i, ch in enumerate(p):
            idx = ord(ch) - ord('a')
            if i > 0 and (ord(ch) - ord(p[i - 1]) + 26) % 26 == 1:
                cur_len += 1
            else:
                cur_len = 1
            if cur_len > max_len_ending_at[idx]:
                max_len_ending_at[idx] = cur_len
        return sum(max_len_ending_at)
