# https://leetcode.com/problems/sum-of-sortable-integers/

class Solution:
    def sumOfSortableIntegers(self, nums: list[int]) -> int:
        n = len(nums)
        sorted_nums = sorted(nums)
        ans = 0

        def is_cyclic_rotation(start, end):
            k = end - start
            block = nums[start:end]
            target = sorted_nums[start:end]
            first = target[0]
            for offset in range(k):
                if block[offset] == first:
                    if all(block[(offset + j) % k] == target[j] for j in range(k)):
                        return True
            return False

        for k in range(1, n + 1):
            if n % k != 0:
                continue
            if all(is_cyclic_rotation(i, i + k) for i in range(0, n, k)):
                ans += k

        return ans
