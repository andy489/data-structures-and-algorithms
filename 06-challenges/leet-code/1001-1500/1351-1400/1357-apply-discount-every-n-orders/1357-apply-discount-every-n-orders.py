# https://leetcode.com/problems/apply-discount-every-n-orders/

class Cashier:
    def __init__(self, n: int, discount: int, products, prices):
        self.n = n
        self.discount = discount
        self.count = 0
        self.prices = dict(zip(products, prices))

    def getBill(self, product, amount) -> float:
        self.count += 1
        total = sum(self.prices[p] * a for p, a in zip(product, amount))
        return total * (100 - self.discount) / 100 if self.count % self.n == 0 else float(total)
