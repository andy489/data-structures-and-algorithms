# https://leetcode.com/problems/candy/

# Solution 1: Two-Pass Greedy — O(n) time, O(n) space
class Solution:
    def candy(self, ratings: list[int]) -> int:
        n = len(ratings)
        candy = [1] * n
        for i in range(1, n):
            if ratings[i] > ratings[i - 1]:
                candy[i] = candy[i - 1] + 1
        for i in range(n - 2, -1, -1):
            if ratings[i] > ratings[i + 1]:
                candy[i] = max(candy[i], candy[i + 1] + 1)
        return sum(candy)


# Solution 2: One-Pass Greedy — O(n) time, O(1) space
class Solution2:
    def candy(self, ratings: list[int]) -> int:
        n = len(ratings)
        ans, up, down, peak = 1, 0, 0, 0
        for i in range(1, n):
            if ratings[i] > ratings[i - 1]:
                down = 0
                up += 1
                peak = up
                ans += up + 1
            elif ratings[i] == ratings[i - 1]:
                up = down = peak = 0
                ans += 1
            else:
                up = 0
                down += 1
                ans += down + 1
                if down >= peak:
                    ans += 1
        return ans
