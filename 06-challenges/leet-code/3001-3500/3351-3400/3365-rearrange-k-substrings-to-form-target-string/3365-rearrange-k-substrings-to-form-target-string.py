# https://leetcode.com/problems/rearrange-k-substrings-to-form-target-string/

class Solution:
    def isPossibleToRearrange(self, s: str, t: str, k: int) -> bool:
        n = len(s)
        length = n // k
        freq = {}
        for i in range(k):
            chunk = s[i * length:(i + 1) * length]
            freq[chunk] = freq.get(chunk, 0) + 1
        for i in range(k):
            chunk = t[i * length:(i + 1) * length]
            if freq.get(chunk, 0) == 0:
                return False
            freq[chunk] -= 1
        return True
