# https://leetcode.com/problems/time-needed-to-buy-tickets/

class Solution:
    def timeRequiredToBuy(self, tickets: list[int], k: int) -> int:
        return sum(
            min(t, tickets[k]) if i <= k else min(t, tickets[k] - 1)
            for i, t in enumerate(tickets)
        )
