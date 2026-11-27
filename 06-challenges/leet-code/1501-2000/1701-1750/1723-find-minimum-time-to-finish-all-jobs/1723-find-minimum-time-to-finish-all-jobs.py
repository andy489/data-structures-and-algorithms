# https://leetcode.com/problems/find-minimum-time-to-finish-all-jobs/

class Solution:
    def minimumTimeRequired(self, jobs: list[int], k: int) -> int:
        n = len(jobs)
        total = 1 << n
        subset_sum = [0] * total
        for mask in range(1, total):
            lsb = mask & (-mask)
            bit = lsb.bit_length() - 1
            subset_sum[mask] = subset_sum[mask ^ lsb] + jobs[bit]

        dp = subset_sum[:]
        for _ in range(k - 1):
            ndp = [float('inf')] * total
            for mask in range(total):
                sub = mask
                while sub:
                    ndp[mask] = min(ndp[mask], max(dp[mask ^ sub], subset_sum[sub]))
                    sub = (sub - 1) & mask
            ndp[0] = 0
            dp = ndp
        return dp[total - 1]
