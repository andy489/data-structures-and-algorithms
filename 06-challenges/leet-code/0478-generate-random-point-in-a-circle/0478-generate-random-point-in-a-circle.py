# https://leetcode.com/problems/generate-random-point-in-a-circle/

import math
import random

class Solution:
    def __init__(self, radius: float, x_center: float, y_center: float):
        self.radius = radius
        self.x_center = x_center
        self.y_center = y_center

    def randPoint(self) -> list[float]:
        angle = 2 * math.pi * random.random()
        r = self.radius * math.sqrt(random.random())
        return [self.x_center + r * math.cos(angle), self.y_center + r * math.sin(angle)]
