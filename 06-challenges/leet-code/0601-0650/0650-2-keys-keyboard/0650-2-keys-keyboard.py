# https://leetcode.com/problems/2-keys-keyboard/

class Solution:
    def minSteps(self, n: int) -> int:
        steps = 0
        factor = 2
        while factor * factor <= n:
            while n % factor == 0:
                steps += factor
                n //= factor
            factor += 1
        if n > 1:
            steps += n
        return steps
