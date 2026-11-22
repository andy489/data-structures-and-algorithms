# https://leetcode.com/problems/majority-element-ii/

class Solution:
    def majorityElement(self, nums: list[int]) -> list[int]:
        cand1, cnt1 = 0, 0
        cand2, cnt2 = 1, 0

        for num in nums:
            if num == cand1:
                cnt1 += 1
            elif num == cand2:
                cnt2 += 1
            elif cnt1 == 0:
                cand1, cnt1 = num, 1
            elif cnt2 == 0:
                cand2, cnt2 = num, 1
            else:
                cnt1 -= 1
                cnt2 -= 1

        threshold = len(nums) // 3
        return [c for c in (cand1, cand2) if nums.count(c) > threshold]
