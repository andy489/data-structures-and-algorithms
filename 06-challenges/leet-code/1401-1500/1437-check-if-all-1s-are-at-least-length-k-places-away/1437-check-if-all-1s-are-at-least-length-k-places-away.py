# https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/

class Solution:
    def kLengthApart(self, nums: list[int], k: int) -> bool:
        prev = -1
        for i, v in enumerate(nums):
            if v == 1:
                if prev != -1 and i - prev - 1 < k:
                    return False
                prev = i
        return True
