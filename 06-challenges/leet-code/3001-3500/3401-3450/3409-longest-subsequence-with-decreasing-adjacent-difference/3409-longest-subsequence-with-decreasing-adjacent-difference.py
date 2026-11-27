# https://leetcode.com/problems/longest-subsequence-with-decreasing-adjacent-difference/
class Solution:
    def longestSubsequence(self, nums: list[int]) -> int:
        MAX_VAL = 301
        # suff_max[v][d] = max length of subsequence ending at value v, last diff >= d
        suff_max = [[0] * MAX_VAL for _ in range(MAX_VAL)]
        ans = 1

        for num in nums:
            cur_best = [0] * MAX_VAL
            for v in range(MAX_VAL):
                diff = abs(num - v)
                if diff < MAX_VAL and suff_max[v][diff] > 0:
                    candidate = suff_max[v][diff] + 1
                    if candidate > cur_best[diff]:
                        cur_best[diff] = candidate

            for d in range(MAX_VAL):
                val = cur_best[d] if cur_best[d] > 0 else 1
                if val > suff_max[num][d]:
                    suff_max[num][d] = val

            # Rebuild suffix max for num
            for d in range(MAX_VAL - 2, -1, -1):
                if suff_max[num][d + 1] > suff_max[num][d]:
                    suff_max[num][d] = suff_max[num][d + 1]
                ans = max(ans, suff_max[num][d])
            ans = max(ans, suff_max[num][MAX_VAL - 1])

        return ans
