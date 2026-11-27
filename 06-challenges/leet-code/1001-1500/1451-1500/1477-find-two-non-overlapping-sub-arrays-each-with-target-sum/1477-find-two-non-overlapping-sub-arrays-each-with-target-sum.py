# https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/

class Solution:
    def minSumOfLengths(self, arr: list[int], target: int) -> int:
        INF = float('inf')
        n = len(arr)
        min_left = [INF] * n
        left = s = 0
        best = INF
        ans = INF
        for right in range(n):
            s += arr[right]
            while s > target:
                s -= arr[left]
                left += 1
            if s == target:
                length = right - left + 1
                best = min(best, length)
                if left > 0 and min_left[left-1] < INF:
                    ans = min(ans, min_left[left-1] + length)
            min_left[right] = best
        return -1 if ans == INF else ans
