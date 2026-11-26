# https://leetcode.com/problems/reverse-pairs/

class Solution:
    def reversePairs(self, nums: list) -> int:
        def merge_sort(arr):
            if len(arr) <= 1:
                return arr, 0
            mid = len(arr) // 2
            left, lc = merge_sort(arr[:mid])
            right, rc = merge_sort(arr[mid:])

            count = lc + rc
            j = 0
            for x in left:
                while j < len(right) and x > 2 * right[j]:
                    j += 1
                count += j

            merged = []
            i = k = 0
            while i < len(left) and k < len(right):
                if left[i] <= right[k]:
                    merged.append(left[i])
                    i += 1
                else:
                    merged.append(right[k])
                    k += 1
            merged.extend(left[i:])
            merged.extend(right[k:])
            return merged, count

        _, result = merge_sort(nums)
        return result
