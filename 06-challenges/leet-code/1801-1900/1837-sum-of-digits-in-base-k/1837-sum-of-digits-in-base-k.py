# https://leetcode.com/problems/sum-of-digits-in-base-k/

class Solution:
    def sumBase(self, n: int, k: int) -> int:
        total = 0
        while n:
            total += n % k
            n //= k
        return total
