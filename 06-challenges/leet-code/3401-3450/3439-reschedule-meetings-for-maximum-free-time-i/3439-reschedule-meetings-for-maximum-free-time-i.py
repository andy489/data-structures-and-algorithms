# https://leetcode.com/problems/reschedule-meetings-for-maximum-free-time-i/
class Solution:
    def maxFreeTime(self, eventTime: int, k: int, startTime: List[int], endTime: List[int]) -> int:
        n = len(startTime)
        gaps = [0] * (n + 1)
        gaps[0] = startTime[0]
        for i in range(1, n):
            gaps[i] = startTime[i] - endTime[i - 1]
        gaps[n] = eventTime - endTime[n - 1]

        window_size = k + 1
        window_sum = sum(gaps[:window_size])
        max_free = window_sum

        for i in range(window_size, n + 1):
            window_sum += gaps[i] - gaps[i - window_size]
            if window_sum > max_free:
                max_free = window_sum

        return max_free
