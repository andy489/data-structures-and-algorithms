# https://leetcode.com/problems/majority-element/

class Solution:
    def majorityElement(self, nums: list[int]) -> int:
        candidate, count = nums[0], 0
        for num in nums:
            if count == 0:
                candidate = num
            count += 1 if num == candidate else -1
        return candidate


class Solution2:
    def majorityElement(self, nums: list[int]) -> int:
        from collections import Counter
        return Counter(nums).most_common(1)[0][0]


class Solution3:
    def majorityElement(self, nums: list[int]) -> int:
        nums.sort()
        return nums[len(nums) // 2]
