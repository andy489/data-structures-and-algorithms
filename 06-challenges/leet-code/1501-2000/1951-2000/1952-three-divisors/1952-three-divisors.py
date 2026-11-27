# https://leetcode.com/problems/three-divisors/
class Solution:
    def isThree(self, n: int) -> bool:
        count = sum(1 for i in range(1, n + 1) if n % i == 0)
        return count == 3
