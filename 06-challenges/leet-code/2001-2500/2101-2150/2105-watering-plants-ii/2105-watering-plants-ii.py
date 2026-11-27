# https://leetcode.com/problems/watering-plants-ii/

# Solution: Two Pointers — O(n) time, O(1) space
class Solution:
    def minimumRefill(self, plants: list[int], capacityA: int, capacityB: int) -> int:
        l, r = 0, len(plants) - 1
        water_a, water_b = capacityA, capacityB
        refills = 0

        while l < r:
            if water_a < plants[l]:
                refills += 1
                water_a = capacityA
            water_a -= plants[l]
            l += 1

            if water_b < plants[r]:
                refills += 1
                water_b = capacityB
            water_b -= plants[r]
            r -= 1

        if l == r:
            if water_a >= water_b:
                if water_a < plants[l]:
                    refills += 1
            else:
                if water_b < plants[l]:
                    refills += 1

        return refills
