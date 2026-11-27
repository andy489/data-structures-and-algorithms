# https://leetcode.com/problems/minimum-time-to-type-word-using-special-typewriter/

class Solution:
    def minTimeToType(self, word: str) -> int:
        time = 0
        cur = 0
        for c in word:
            nxt = ord(c) - ord('a')
            diff = abs(cur - nxt)
            time += min(diff, 26 - diff) + 1
            cur = nxt
        return time
