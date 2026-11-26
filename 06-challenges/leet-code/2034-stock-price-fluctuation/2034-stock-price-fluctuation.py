# https://leetcode.com/problems/stock-price-fluctuation/

class StockPrice:
    def __init__(self):
        from sortedcontainers import SortedList
        from collections import defaultdict
        self.prices = {}
        self.sorted_prices = SortedList()
        self.max_time = 0

    def update(self, timestamp: int, price: int) -> None:
        self.max_time = max(self.max_time, timestamp)
        if timestamp in self.prices:
            self.sorted_prices.remove(self.prices[timestamp])
        self.prices[timestamp] = price
        self.sorted_prices.add(price)

    def current(self) -> int:
        return self.prices[self.max_time]

    def maximum(self) -> int:
        return self.sorted_prices[-1]

    def minimum(self) -> int:
        return self.sorted_prices[0]
