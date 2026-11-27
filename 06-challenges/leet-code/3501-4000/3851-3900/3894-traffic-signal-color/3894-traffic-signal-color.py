# https://leetcode.com/problems/traffic-signal-color/
class Solution:
    def trafficSignalColor(self, timer: int) -> str:
        if timer == 0:
            return "Green"
        elif timer == 30:
            return "Orange"
        elif 30 < timer <= 90:
            return "Red"
        else:
            return "Invalid"
