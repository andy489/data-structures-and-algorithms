# https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/
class Solution:
    def divideString(self, s: str, k: int, fill: str) -> list:
        rem = len(s) % k
        if rem != 0:
            s += fill * (k - rem)
        return [s[i:i+k] for i in range(0, len(s), k)]
