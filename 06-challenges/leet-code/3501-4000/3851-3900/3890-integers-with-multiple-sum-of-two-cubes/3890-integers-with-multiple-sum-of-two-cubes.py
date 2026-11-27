# https://leetcode.com/problems/integers-with-multiple-sum-of-two-cubes/
class Solution:
    def getGoodIntegers(self, n: int) -> list[int]:
        from collections import defaultdict

        count_map = defaultdict(int)
        limit = int(n ** (1 / 3)) + 2

        for a in range(1, limit + 1):
            for b in range(a, limit + 1):
                s = a ** 3 + b ** 3
                if s > n:
                    break
                count_map[s] += 1

        result = sorted(k for k, v in count_map.items() if v >= 2)
        return result
