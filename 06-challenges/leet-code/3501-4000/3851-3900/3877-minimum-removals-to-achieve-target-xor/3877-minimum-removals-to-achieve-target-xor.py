# https://leetcode.com/problems/minimum-removals-to-achieve-target-xor/

class Solution:
    def minRemovals(self, nums: list[int], target: int) -> int:
        n = len(nums)
        half = n // 2
        left_map = {}
        for mask in range(1 << half):
            xor, cnt = 0, 0
            for i in range(half):
                if (mask >> i) & 1:
                    xor ^= nums[i]
                    cnt += 1
            if xor not in left_map or left_map[xor] < cnt:
                left_map[xor] = cnt

        max_kept = -1
        right_len = n - half
        for mask in range(1 << right_len):
            xor, cnt = 0, 0
            for i in range(right_len):
                if (mask >> i) & 1:
                    xor ^= nums[half + i]
                    cnt += 1
            need = xor ^ target
            if need in left_map:
                max_kept = max(max_kept, cnt + left_map[need])

        return -1 if max_kept == -1 else n - max_kept
