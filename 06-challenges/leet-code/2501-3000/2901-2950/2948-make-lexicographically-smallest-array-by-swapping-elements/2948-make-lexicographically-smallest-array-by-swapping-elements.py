# https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/

class Solution:
    def lexicographicallySmallestArray(self, nums: list[int], limit: int) -> list[int]:
        n = len(nums)
        indices = sorted(range(n), key=lambda x: nums[x])
        result = [0] * n
        i = 0
        while i < n:
            j = i + 1
            while j < n and nums[indices[j]] - nums[indices[j - 1]] <= limit:
                j += 1
            group_idx = sorted(indices[i:j])
            sorted_vals = [nums[indices[x]] for x in range(i, j)]
            for k, idx in enumerate(group_idx):
                result[idx] = sorted_vals[k]
            i = j
        return result
