# https://leetcode.com/problems/ant-on-the-boundary/

class Solution:
    def returnToBoundaryCount(self, nums: list[int]) -> int:
        pos = count = 0
        for x in nums:
            pos += x
            if pos == 0:
                count += 1
        return count
