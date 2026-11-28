# https://leetcode.com/problems/unique-3-digit-even-numbers/

from collections import Counter

class Solution:
    def totalNumbers(self, digits: list[int]) -> int:
        freq = Counter(digits)
        count = 0
        for num in range(100, 999, 2):
            h, t, u = num // 100, (num // 10) % 10, num % 10
            needed = Counter([h, t, u])
            if all(freq[d] >= needed[d] for d in needed):
                count += 1
        return count
