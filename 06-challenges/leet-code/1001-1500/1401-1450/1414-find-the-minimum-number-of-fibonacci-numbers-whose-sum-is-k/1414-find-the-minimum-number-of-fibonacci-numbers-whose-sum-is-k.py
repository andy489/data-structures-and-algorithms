# https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/

class Solution:
    def findMinFibonacciNumbers(self, k: int) -> int:
        fibs = [1, 1]
        while fibs[-1] < k:
            fibs.append(fibs[-1] + fibs[-2])
        count = 0
        for f in reversed(fibs):
            if f <= k:
                k -= f
                count += 1
                if k == 0:
                    break
        return count
