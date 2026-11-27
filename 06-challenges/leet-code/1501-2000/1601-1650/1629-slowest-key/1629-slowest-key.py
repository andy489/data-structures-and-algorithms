# https://leetcode.com/problems/slowest-key/

class Solution:
    def slowestKey(self, releaseTimes: list[int], keysPressed: str) -> str:
        max_dur = releaseTimes[0]
        ans = keysPressed[0]
        for i in range(1, len(releaseTimes)):
            dur = releaseTimes[i] - releaseTimes[i - 1]
            key = keysPressed[i]
            if dur > max_dur or (dur == max_dur and key > ans):
                max_dur = dur
                ans = key
        return ans
