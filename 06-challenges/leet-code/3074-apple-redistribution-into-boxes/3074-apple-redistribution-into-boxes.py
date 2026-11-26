# https://leetcode.com/problems/apple-redistribution-into-boxes/

class Solution:
    def minimumBoxes(self, apple: list[int], capacity: list[int]) -> int:
        total = sum(apple)
        capacity.sort(reverse=True)
        s = count = 0
        for c in capacity:
            s += c
            count += 1
            if s >= total:
                break
        return count
