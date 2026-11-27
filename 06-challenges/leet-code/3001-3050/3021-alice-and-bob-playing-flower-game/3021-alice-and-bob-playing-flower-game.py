# https://leetcode.com/problems/alice-and-bob-playing-flower-game/

class Solution:
    def flowerGame(self, n: int, m: int) -> int:
        odd_x, even_x = (n + 1) // 2, n // 2
        odd_y, even_y = (m + 1) // 2, m // 2
        return odd_x * even_y + even_x * odd_y
