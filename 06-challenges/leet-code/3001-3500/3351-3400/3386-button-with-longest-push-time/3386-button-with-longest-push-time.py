# https://leetcode.com/problems/button-with-longest-push-time/

class Solution:
    def buttonWithLongestTime(self, events: list[list[int]]) -> int:
        best_idx = events[0][0]
        best_time = events[0][1]
        for i in range(1, len(events)):
            duration = events[i][1] - events[i - 1][1]
            if duration > best_time or (duration == best_time and events[i][0] < best_idx):
                best_time = duration
                best_idx = events[i][0]
        return best_idx
