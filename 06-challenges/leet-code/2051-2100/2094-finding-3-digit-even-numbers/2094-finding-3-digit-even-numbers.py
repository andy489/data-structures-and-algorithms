# https://leetcode.com/problems/finding-3-digit-even-numbers/

class Solution:
    def findEvenNumbers(self, digits: list[int]) -> list[int]:
        from collections import Counter
        freq = Counter(digits)
        res = []
        for num in range(100, 999, 2):
            used = Counter(int(d) for d in str(num))
            if all(used[d] <= freq[d] for d in used):
                res.append(num)
        return res
