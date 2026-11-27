# https://leetcode.com/problems/product-of-the-last-k-numbers/

class ProductOfNumbers:
    def __init__(self):
        self.prefix = [1]

    def add(self, num: int) -> None:
        if num == 0:
            self.prefix = [1]
        else:
            self.prefix.append(self.prefix[-1] * num)

    def getProduct(self, k: int) -> int:
        n = len(self.prefix)
        if k >= n:
            return 0
        return self.prefix[-1] // self.prefix[n - 1 - k]
