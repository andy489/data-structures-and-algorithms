# https://leetcode.com/problems/boats-to-save-people/

class Solution:
    def numRescueBoats(self, people: list[int], limit: int) -> int:
        people.sort()
        lo, hi, boats = 0, len(people) - 1, 0
        while lo <= hi:
            if people[lo] + people[hi] <= limit:
                lo += 1
            hi -= 1
            boats += 1
        return boats
