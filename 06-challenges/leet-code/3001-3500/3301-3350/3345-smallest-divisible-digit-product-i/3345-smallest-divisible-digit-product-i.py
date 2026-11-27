# https://leetcode.com/problems/smallest-divisible-digit-product-i/

# Solution: Linear Scan — O(1) time (bounded n), O(1) space
class Solution:
    def smallestNumber(self, n: int, t: int) -> int:
        def digit_product(x: int) -> int:
            prod = 1
            while x > 0:
                prod *= x % 10
                x //= 10
            return prod

        x = n
        while digit_product(x) % t != 0:
            x += 1
        return x
