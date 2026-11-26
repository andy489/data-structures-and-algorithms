# https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/

class Solution:
    def subtractProductAndSum(self, n: int) -> int:
        product, s = 1, 0
        while n:
            d = n % 10
            product *= d
            s += d
            n //= 10
        return product - s
