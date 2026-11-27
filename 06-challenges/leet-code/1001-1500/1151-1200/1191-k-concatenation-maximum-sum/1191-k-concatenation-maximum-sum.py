# https://leetcode.com/problems/k-concatenation-maximum-sum/

# Solution: Kadane + Total Sum — O(n) time, O(1) space
class Solution:
    MOD = 10 ** 9 + 7

    def kConcatenationMaxSum(self, arr: list[int], k: int) -> int:
        def kadane(repeat: int) -> int:
            max_sum = cur = 0
            for _ in range(repeat):
                for x in arr:
                    cur = max(0, cur + x)
                    max_sum = max(max_sum, cur)
            return max_sum

        total = sum(arr)
        if k == 1:
            return kadane(1) % self.MOD
        max_sub2 = kadane(2)
        if total > 0:
            return (max_sub2 + (k - 2) * total) % self.MOD
        return max_sub2 % self.MOD
