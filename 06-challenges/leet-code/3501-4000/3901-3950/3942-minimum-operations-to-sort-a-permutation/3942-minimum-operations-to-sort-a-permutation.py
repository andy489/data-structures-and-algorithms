# https://leetcode.com/problems/minimum-operations-to-sort-a-permutation/
class Solution:
    def minOperations(self, nums: list[int]) -> int:
        n = len(nums)
        # Check already sorted
        if nums == list(range(n)):
            return 0

        def is_rotation_of(arr, target):
            # Check if arr is a cyclic rotation of target
            # Find first element of target in arr
            start = target[0]
            positions = [i for i, v in enumerate(arr) if v == start]
            for pos in positions:
                if all(arr[(pos + i) % n] == target[i] for i in range(n)):
                    return pos
            return -1

        sorted_asc = list(range(n))
        sorted_desc = list(range(n - 1, -1, -1))

        pos_asc = is_rotation_of(nums, sorted_asc)
        pos_desc = is_rotation_of(nums, sorted_desc)

        if pos_asc == -1 and pos_desc == -1:
            return -1

        ans = float('inf')
        if pos_asc != -1:
            # rotate left pos_asc times
            ans = min(ans, pos_asc)
        if pos_desc != -1:
            # option 1: reverse (1 op) then rotate left pos_desc times
            ans = min(ans, 1 + pos_desc)
            # option 2: rotate left (n - pos_desc) % n times then reverse (1 op)
            ans = min(ans, 1 + (n - pos_desc) % n)
        return ans
