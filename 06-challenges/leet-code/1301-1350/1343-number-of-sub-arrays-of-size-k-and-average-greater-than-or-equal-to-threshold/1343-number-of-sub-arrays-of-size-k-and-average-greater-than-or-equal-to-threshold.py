# https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/

class Solution:
    def numOfSubarrays(self, arr: list[int], k: int, threshold: int) -> int:
        window = sum(arr[:k])
        limit = k * threshold
        count = int(window >= limit)
        for i in range(k, len(arr)):
            window += arr[i] - arr[i-k]
            if window >= limit:
                count += 1
        return count
