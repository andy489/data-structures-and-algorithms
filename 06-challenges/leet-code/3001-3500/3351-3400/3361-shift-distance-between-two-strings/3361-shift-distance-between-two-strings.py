# https://leetcode.com/problems/shift-distance-between-two-strings/

# Solution: Prefix Sum on Circular Alphabet — O(n + 26) time, O(26) space
class Solution:
    def shiftDistance(self, s: str, t: str, nextCost: list[int], previousCost: list[int]) -> int:
        # Prefix sums on doubled alphabet for forward direction
        next_pre = [0] * 53
        for i in range(52):
            next_pre[i + 1] = next_pre[i] + nextCost[i % 26]

        # Reversed prefix sums for backward direction
        rev_prev_pre = [0] * 53
        for i in range(51, -1, -1):
            rev_prev_pre[i] = rev_prev_pre[i + 1] + previousCost[i % 26]

        ans = 0
        for ca, cb in zip(s, t):
            a = ord(ca) - ord('a')
            b = ord(cb) - ord('a')
            if a == b:
                continue
            fwd_steps = (b - a + 26) % 26
            fwd_cost = next_pre[a + fwd_steps] - next_pre[a]

            bwd_steps = (a - b + 26) % 26
            start = 51 - a
            bwd_cost = rev_prev_pre[start] - rev_prev_pre[start + bwd_steps]

            ans += min(fwd_cost, bwd_cost)
        return ans
