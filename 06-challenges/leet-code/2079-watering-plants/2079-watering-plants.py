# https://leetcode.com/problems/watering-plants/

class Solution:
    def wateringPlants(self, plants: list[int], capacity: int) -> int:
        steps, water = 0, capacity
        for i, need in enumerate(plants):
            if water < need:
                steps += 2 * i
                water = capacity
            steps += 1
            water -= need
        return steps
