# https://leetcode.com/problems/count-elements-with-strictly-smaller-and-greater-elements/
class Solution:
    def countElements(self, nums: List[int]) -> int:
        mn, mx = min(nums), max(nums)
        return sum(1 for x in nums if mn < x < mx)
