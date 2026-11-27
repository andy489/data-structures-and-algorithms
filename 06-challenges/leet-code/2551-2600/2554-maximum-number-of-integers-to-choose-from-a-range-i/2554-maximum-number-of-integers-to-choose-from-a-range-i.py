# https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/

# Solution: Greedy with HashSet — O(n + b) time, O(b) space
class Solution:
    def maxCount(self, banned: list[int], n: int, maxSum: int) -> int:
        banned_set = set(banned)
        count = 0
        total = 0
        for i in range(1, n + 1):
            if i in banned_set:
                continue
            if total + i > maxSum:
                break
            total += i
            count += 1
        return count
