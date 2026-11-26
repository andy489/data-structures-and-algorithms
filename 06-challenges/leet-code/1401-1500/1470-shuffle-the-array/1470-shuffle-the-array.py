# https://leetcode.com/problems/shuffle-the-array/

class Solution:
    def shuffle(self, nums: list[int], n: int) -> list[int]:
        res = []
        for i in range(n):
            res.extend([nums[i], nums[i+n]])
        return res
