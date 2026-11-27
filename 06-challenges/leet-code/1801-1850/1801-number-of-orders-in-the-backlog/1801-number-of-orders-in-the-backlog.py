# https://leetcode.com/problems/number-of-orders-in-the-backlog/

import heapq

class Solution:
    def getNumberOfBacklogOrders(self, orders: list[list[int]]) -> int:
        buy = []   # max-heap (negate prices)
        sell = []  # min-heap
        MOD = 10**9 + 7
        for price, amount, typ in orders:
            if typ == 0:  # buy
                while amount and sell and sell[0][0] <= price:
                    sp, sa = heapq.heappop(sell)
                    matched = min(amount, sa)
                    amount -= matched
                    sa -= matched
                    if sa:
                        heapq.heappush(sell, (sp, sa))
                if amount:
                    heapq.heappush(buy, (-price, amount))
            else:  # sell
                while amount and buy and -buy[0][0] >= price:
                    bp, ba = heapq.heappop(buy)
                    matched = min(amount, ba)
                    amount -= matched
                    ba -= matched
                    if ba:
                        heapq.heappush(buy, (bp, ba))
                if amount:
                    heapq.heappush(sell, (price, amount))
        return (sum(a for _, a in buy) + sum(a for _, a in sell)) % MOD
