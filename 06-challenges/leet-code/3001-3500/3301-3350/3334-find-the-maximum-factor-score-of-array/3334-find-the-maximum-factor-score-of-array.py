# https://leetcode.com/problems/find-the-maximum-factor-score-of-array/

from math import gcd, lcm

class Solution:
    def maxScore(self, nums: list[int]) -> int:
        n = len(nums)
        if n == 1:
            return nums[0] * nums[0]

        pref_gcd = [0] * (n + 1)
        pref_lcm = [0] * (n + 1)
        suf_gcd = [0] * (n + 1)
        suf_lcm = [0] * (n + 1)

        for i in range(n):
            pref_gcd[i + 1] = gcd(pref_gcd[i], nums[i])
            pref_lcm[i + 1] = nums[i] if pref_lcm[i] == 0 else lcm(pref_lcm[i], nums[i])

        for i in range(n - 1, -1, -1):
            suf_gcd[i] = gcd(suf_gcd[i + 1], nums[i])
            suf_lcm[i] = nums[i] if suf_lcm[i + 1] == 0 else lcm(suf_lcm[i + 1], nums[i])

        ans = pref_gcd[n] * pref_lcm[n]  # no removal
        for i in range(n):
            g = gcd(pref_gcd[i], suf_gcd[i + 1])
            if pref_lcm[i] == 0:
                l = suf_lcm[i + 1]
            elif suf_lcm[i + 1] == 0:
                l = pref_lcm[i]
            else:
                l = lcm(pref_lcm[i], suf_lcm[i + 1])
            ans = max(ans, g * l)
        return ans
