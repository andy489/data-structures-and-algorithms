# https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/

class Solution:
    def smallerNumbersThanCurrent(self, nums: list[int]) -> list[int]:
        cnt = [0] * 102
        for v in nums:
            cnt[v+1] += 1
        for i in range(1, len(cnt)):
            cnt[i] += cnt[i-1]
        return [cnt[v] for v in nums]
