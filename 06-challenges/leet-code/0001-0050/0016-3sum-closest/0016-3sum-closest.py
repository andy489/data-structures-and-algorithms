# https://leetcode.com/problems/3sum-closest/

class Solution:
    def threeSumClosest(self, nums: list[int], target: int) -> int:
        nums.sort()
        n = len(nums)
        closest = nums[0] + nums[1] + nums[2]

        for i in range(n - 2):
            l, r = i + 1, n - 1

            while l < r:
                cur = nums[i] + nums[l] + nums[r]

                if cur == target:
                    return cur

                if abs(cur - target) < abs(closest - target):
                    closest = cur

                if cur < target:
                    l += 1
                else:
                    r -= 1

        return closest
