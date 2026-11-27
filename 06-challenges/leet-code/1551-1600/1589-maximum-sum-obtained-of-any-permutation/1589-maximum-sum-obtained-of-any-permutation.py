# https://leetcode.com/problems/maximum-sum-obtained-of-any-permutation/

class Solution:
    def maxSumRangeQuery(self, nums: list[int], requests: list[list[int]]) -> int:
        MOD = 10**9 + 7
        n = len(nums)
        freq = [0] * (n + 1)
        for l, r in requests:
            freq[l] += 1
            freq[r + 1] -= 1
        for i in range(1, n):
            freq[i] += freq[i - 1]
        nums.sort()
        freq_sorted = sorted(freq[:n])
        return sum(a * b for a, b in zip(nums, freq_sorted)) % MOD
