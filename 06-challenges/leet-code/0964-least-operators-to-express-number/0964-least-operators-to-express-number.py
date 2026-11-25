# https://leetcode.com/problems/least-operators-to-express-number/

class Solution:
    def leastOpsExpressTarget(self, x: int, target: int) -> int:
        pos = neg = k = 0
        while target > 0:
            d = target % x
            target //= x
            if k == 0:
                pos = d * 2
                neg = (x - d) * 2
            else:
                pos, neg = (
                    min(pos + d * 2 * k, neg + (d + 1) * 2 * k),
                    min(pos + (x - d) * 2 * k, neg + (x - d - 1) * 2 * k)
                )
            k += 1
        return min(pos, neg + 2 * k) - 1
