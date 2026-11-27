# https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/

# Solution: DP with Two States — O(n) time, O(1) space
class Solution:
    def maximumSum(self, arr: list[int]) -> int:
        no_delete = arr[0]
        one_delete = 0
        ans = arr[0]
        for i in range(1, len(arr)):
            one_delete = max(no_delete, one_delete + arr[i])
            no_delete = max(arr[i], no_delete + arr[i])
            ans = max(ans, no_delete, one_delete)
        return ans
