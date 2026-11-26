# https://leetcode.com/problems/can-convert-string-in-k-moves/

class Solution:
    def canConvertString(self, s: str, t: str, k: int) -> bool:
        if len(s) != len(t):
            return False
        count = [0] * 26
        for a, b in zip(s, t):
            diff = (ord(b) - ord(a)) % 26
            if diff != 0:
                count[diff] += 1
                if count[diff] * 26 - 26 + diff > k:
                    return False
        return True
