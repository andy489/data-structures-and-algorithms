# https://leetcode.com/problems/maximum-candies-you-can-get-from-boxes/

from collections import deque
class Solution:
    def maxCandies(self, status: list[int], candies: list[int], keys: list[list[int]], containedBoxes: list[list[int]], initialBoxes: list[int]) -> int:
        possessed, opened = set(), set()
        q = deque()
        for b in initialBoxes:
            possessed.add(b)
            if status[b]: q.append(b)
        total = 0
        while q:
            b = q.popleft()
            total += candies[b]
            for k in keys[b]:
                opened.add(k)
                if k in possessed: q.append(k)
            for cb in containedBoxes[b]:
                possessed.add(cb)
                if status[cb] or cb in opened: q.append(cb)
        return total
