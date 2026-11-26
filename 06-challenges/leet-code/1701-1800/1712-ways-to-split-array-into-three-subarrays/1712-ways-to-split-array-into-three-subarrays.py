# https://leetcode.com/problems/ways-to-split-array-into-three-subarrays/

import bisect

class Solution:
    def waysToSplit(self, nums: list[int]) -> int:
        MOD = 10 ** 9 + 7
        n = len(nums)
        pre = [0] * (n + 1)
        for i in range(n):
            pre[i + 1] = pre[i] + nums[i]

        result = 0
        for i in range(n - 2):
            left_sum = pre[i + 1]
            if left_sum * 3 > pre[n]:
                break
            # min j: pre[j+1] - pre[i+1] >= left_sum => pre[j+1] >= left_sum + pre[i+1]
            min_j = bisect.bisect_left(pre, left_sum + pre[i + 1], i + 2, n) - 1
            if min_j >= n - 1:
                break
            # max j: 2*pre[j+1] <= pre[n] + pre[i+1]
            max_j = bisect.bisect_right(pre, (pre[n] + pre[i + 1]) // 2, min_j + 1, n) - 1
            result = (result + max(0, max_j - min_j + 1)) % MOD
        return result
