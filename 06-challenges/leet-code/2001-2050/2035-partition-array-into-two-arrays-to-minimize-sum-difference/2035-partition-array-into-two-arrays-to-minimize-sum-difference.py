# https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/

class Solution:
    def minimumDifference(self, nums: list[int]) -> int:
        import bisect
        n = len(nums) // 2
        total = sum(nums)
        left_sums = [[] for _ in range(n + 1)]
        right_sums = [[] for _ in range(n + 1)]
        for mask in range(1 << n):
            sl, sr = 0, 0
            bl, br = 0, 0
            for i in range(n):
                if mask >> i & 1:
                    sl += nums[i]
                    bl += 1
                    sr += nums[i + n]
                    br += 1
            left_sums[bl].append(sl)
            right_sums[br].append(sr)
        for lst in right_sums:
            lst.sort()
        res = float('inf')
        for k in range(n + 1):
            rs = right_sums[n - k]
            for ls in left_sums[k]:
                target = total // 2 - ls
                pos = bisect.bisect_left(rs, target)
                for p in [pos - 1, pos]:
                    if 0 <= p < len(rs):
                        s1 = ls + rs[p]
                        res = min(res, abs(total - 2 * s1))
        return res
