# https://leetcode.com/problems/number-of-burgers-with-no-waste-of-ingredients/

class Solution:
    def numOfBurgers(self, tomatoSlices: int, cheeseSlices: int) -> list[int]:
        diff = tomatoSlices - 2 * cheeseSlices
        if diff < 0 or diff % 2 != 0: return []
        jumbo = diff // 2
        small = cheeseSlices - jumbo
        return [jumbo, small] if small >= 0 else []
