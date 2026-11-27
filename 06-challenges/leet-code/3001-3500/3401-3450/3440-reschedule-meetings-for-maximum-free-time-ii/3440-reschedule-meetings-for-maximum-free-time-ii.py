# https://leetcode.com/problems/reschedule-meetings-for-maximum-free-time-ii/
class Solution:
    def maxFreeTime(self, eventTime: int, startTime: List[int], endTime: List[int]) -> int:
        n = len(startTime)
        gaps = [0] * (n + 1)
        gaps[0] = startTime[0]
        for i in range(1, n):
            gaps[i] = startTime[i] - endTime[i - 1]
        gaps[n] = eventTime - endTime[n - 1]

        duration = [endTime[i] - startTime[i] for i in range(n)]

        # prefixMax[i] = max(gaps[0..i-1])
        prefix_max = [0] * (n + 2)
        for i in range(1, n + 2):
            prefix_max[i] = max(prefix_max[i - 1], gaps[i - 1])

        # suffixMax[i] = max(gaps[i..n])
        suffix_max = [0] * (n + 2)
        for i in range(n, -1, -1):
            suffix_max[i] = max(suffix_max[i + 1], gaps[i])

        ans = 0
        for i in range(n):
            merged = gaps[i] + duration[i] + gaps[i + 1]
            best_other = max(prefix_max[i], suffix_max[i + 2])
            if best_other >= duration[i]:
                ans = max(ans, merged)
            else:
                ans = max(ans, gaps[i] + gaps[i + 1])

        return ans
