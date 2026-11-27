# https://leetcode.com/problems/count-of-range-sum/

class Solution:
    def countRangeSum(self, nums: list[int], lower: int, upper: int) -> int:
        prefix = [0] * (len(nums) + 1)
        for i, n in enumerate(nums):
            prefix[i + 1] = prefix[i] + n

        self.count = 0

        def merge_sort(arr):
            if len(arr) <= 1:
                return arr
            mid = len(arr) // 2
            left = merge_sort(arr[:mid])
            right = merge_sort(arr[mid:])
            lo = hi = 0
            for l in left:
                while lo < len(right) and right[lo] - l < lower:
                    lo += 1
                while hi < len(right) and right[hi] - l <= upper:
                    hi += 1
                self.count += hi - lo
            merged = []
            i = j = 0
            while i < len(left) and j < len(right):
                if left[i] <= right[j]:
                    merged.append(left[i])
                    i += 1
                else:
                    merged.append(right[j])
                    j += 1
            merged.extend(left[i:])
            merged.extend(right[j:])
            return merged

        merge_sort(prefix)
        return self.count
