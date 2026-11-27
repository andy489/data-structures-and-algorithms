# https://leetcode.com/problems/filling-bookcase-shelves/

# Solution: Dynamic Programming — O(n²) time, O(n) space
class Solution:
    def minHeightShelves(self, books: List[List[int]], shelfWidth: int) -> int:
        n = len(books)
        dp = [float('inf')] * (n + 1)
        dp[0] = 0
        for i in range(1, n + 1):
            width = 0
            max_h = 0
            for j in range(i, 0, -1):
                width += books[j - 1][0]
                if width > shelfWidth:
                    break
                max_h = max(max_h, books[j - 1][1])
                dp[i] = min(dp[i], dp[j - 1] + max_h)
        return dp[n]
