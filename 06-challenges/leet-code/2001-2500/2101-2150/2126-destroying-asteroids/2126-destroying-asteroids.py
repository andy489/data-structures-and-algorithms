# https://leetcode.com/problems/destroying-asteroids/
class Solution:
    def asteroidsDestroyed(self, mass: int, asteroids: list[int]) -> bool:
        asteroids.sort()
        for a in asteroids:
            if mass < a:
                return False
            mass += a
        return True
