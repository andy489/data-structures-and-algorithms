# https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/

class Solution:
    def maxScore(self, cardPoints: list[int], k: int) -> int:
        n, total = len(cardPoints), sum(cardPoints)
        w = n - k
        if w == 0:
            return total
        window = sum(cardPoints[:w])
        min_window = window
        for i in range(w, n):
            window += cardPoints[i] - cardPoints[i - w]
            min_window = min(min_window, window)
        return total - min_window
