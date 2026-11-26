# https://leetcode.com/problems/car-fleet-ii/

class Solution:
    def getCollisionTimes(self, cars: list[list[int]]) -> list[float]:
        n = len(cars)
        ans = [-1.0] * n
        stack = []  # indices from right to left
        for i in range(n - 1, -1, -1):
            pos, speed = cars[i]
            while stack:
                j = stack[-1]
                pos_j, speed_j = cars[j]
                if speed <= speed_j:
                    stack.pop()
                    continue
                t = (pos_j - pos) / (speed - speed_j)
                if ans[j] != -1 and t >= ans[j]:
                    stack.pop()
                    continue
                ans[i] = t
                break
            stack.append(i)
        return ans
