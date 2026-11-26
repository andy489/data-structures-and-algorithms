# https://leetcode.com/problems/maximum-equal-frequency/

class Solution:
    def maxEqualFreq(self, nums: list[int]) -> int:
        from collections import defaultdict
        count = defaultdict(int)
        cnt_cnt = defaultdict(int)
        max_freq = res = 0
        for i, x in enumerate(nums):
            old = count[x]
            if old > 0: cnt_cnt[old] -= 1
            count[x] += 1
            cnt_cnt[old+1] += 1
            max_freq = max(max_freq, old+1)
            n = i + 1
            if (max_freq == 1 or
                max_freq * cnt_cnt[max_freq] == n - 1 or
                (max_freq+1) == n or
                max_freq * cnt_cnt[max_freq] == n and cnt_cnt[max_freq] == 1):
                res = n
        return res
