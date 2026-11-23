# https://leetcode.com/problems/binary-watch/

class Solution:
    def readBinaryWatch(self, turnedOn: int) -> list[str]:
        return [
            f"{h}:{m:02d}"
            for h in range(12)
            for m in range(60)
            if bin(h).count('1') + bin(m).count('1') == turnedOn
        ]
