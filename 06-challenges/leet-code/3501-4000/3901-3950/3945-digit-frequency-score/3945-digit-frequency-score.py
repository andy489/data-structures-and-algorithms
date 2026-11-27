# https://leetcode.com/problems/digit-frequency-score/
class Solution:
    def digitScore(self, n: int) -> int:
        freq = [0] * 10
        while n > 0:
            freq[n % 10] += 1
            n //= 10
        return sum(d * freq[d] for d in range(10))
