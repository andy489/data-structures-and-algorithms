# https://leetcode.com/problems/fruits-into-baskets-ii/

class Solution:
    def numOfUnplacedFruits(self, fruits: list[int], baskets: list[int]) -> int:
        n = len(fruits)
        used = [False] * n
        unplaced = 0
        for f in fruits:
            placed = False
            for j in range(n):
                if not used[j] and baskets[j] >= f:
                    used[j] = True
                    placed = True
                    break
            if not placed:
                unplaced += 1
        return unplaced
