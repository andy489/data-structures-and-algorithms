# https://leetcode.com/problems/maximum-number-of-balloons/

# Solution: Frequency Count — O(n) time, O(1) space
class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        from collections import Counter
        cnt = Counter(text)
        return min(cnt['b'], cnt['a'], cnt['l'] // 2, cnt['o'] // 2, cnt['n'])
