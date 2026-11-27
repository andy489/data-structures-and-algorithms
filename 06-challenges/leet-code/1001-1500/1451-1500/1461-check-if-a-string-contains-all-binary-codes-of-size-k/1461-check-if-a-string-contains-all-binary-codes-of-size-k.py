# https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/

class Solution:
    def hasAllCodes(self, s: str, k: int) -> bool:
        return len({s[i:i+k] for i in range(len(s)-k+1)}) == 1 << k
