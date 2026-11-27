# https://leetcode.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day/

class Solution:
    def canEat(self, candiesCount: list[int], queries: list[list[int]]) -> list[bool]:
        prefix = [0] * (len(candiesCount) + 1)
        for i, c in enumerate(candiesCount):
            prefix[i + 1] = prefix[i] + c
        answer = []
        for t, day, cap in queries:
            answer.append(day >= prefix[t] and (day + 1) * cap > prefix[t])
        return answer
