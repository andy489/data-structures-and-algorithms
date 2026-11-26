# https://leetcode.com/problems/tallest-billboard/

class Solution:
    def tallestBillboard(self, rods: list[int]) -> int:
        dp = {0: 0}
        for r in rods:
            cur = dict(dp)
            for diff, tall in cur.items():
                dp[diff + r] = max(dp.get(diff + r, 0), tall + r)
                new_diff = abs(diff - r)
                new_tall = tall if diff >= r else tall + r - diff
                dp[new_diff] = max(dp.get(new_diff, 0), new_tall)
        return dp.get(0, 0)
