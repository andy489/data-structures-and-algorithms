# https://leetcode.com/problems/rearrange-array-elements-by-sign/
class Solution:
    def rearrangeArray(self, nums: List[int]) -> List[int]:
        result = [0] * len(nums)
        pos_idx, neg_idx = 0, 1
        for x in nums:
            if x > 0:
                result[pos_idx] = x
                pos_idx += 2
            else:
                result[neg_idx] = x
                neg_idx += 2
        return result
