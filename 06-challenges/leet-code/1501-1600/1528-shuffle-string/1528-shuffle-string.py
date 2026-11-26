# https://leetcode.com/problems/shuffle-string/

class Solution:
    def restoreString(self, s: str, indices: list[int]) -> str:
        result = [''] * len(s)
        for i, idx in enumerate(indices):
            result[idx] = s[i]
        return ''.join(result)
