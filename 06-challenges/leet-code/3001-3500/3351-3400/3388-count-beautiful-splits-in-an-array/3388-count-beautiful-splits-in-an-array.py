# https://leetcode.com/problems/count-beautiful-splits-in-an-array/

class Solution:
    def beautifulSplits(self, nums: list[int]) -> int:
        n = len(nums)
        # lcp[i][j] = LCP length of nums[i:] and nums[j:]
        lcp = [[0] * (n + 1) for _ in range(n + 1)]
        for i in range(n - 1, -1, -1):
            for j in range(n - 1, -1, -1):
                if nums[i] == nums[j]:
                    lcp[i][j] = lcp[i + 1][j + 1] + 1

        count = 0
        for i in range(1, n - 1):
            for j in range(i + 1, n):
                len1, len2, len3 = i, j - i, n - j
                cond_a = len1 <= len2 and lcp[0][i] >= len1
                cond_b = len2 <= len3 and lcp[i][j] >= len2
                if cond_a or cond_b:
                    count += 1
        return count
