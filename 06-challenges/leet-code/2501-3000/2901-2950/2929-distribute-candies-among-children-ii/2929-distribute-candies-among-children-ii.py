# https://leetcode.com/problems/distribute-candies-among-children-ii/

class Solution:
    def distributeCandies(self, n: int, limit: int) -> int:
        def f(x: int) -> int:
            if x < 0:
                return 0
            return (x + 1) * (x + 2) // 2

        return (f(n)
                - 3 * f(n - limit - 1)
                + 3 * f(n - 2 * (limit + 1))
                - f(n - 3 * (limit + 1)))
