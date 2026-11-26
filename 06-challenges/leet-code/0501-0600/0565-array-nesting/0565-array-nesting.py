from typing import List


class Solution:
    def arrayNesting(self, nums: List[int]) -> int:
        visited = [False] * len(nums)
        max_len = 0
        for i in range(len(nums)):
            if visited[i]:
                continue
            count = 0
            j = i
            while not visited[j]:
                visited[j] = True
                j = nums[j]
                count += 1
            max_len = max(max_len, count)
        return max_len
