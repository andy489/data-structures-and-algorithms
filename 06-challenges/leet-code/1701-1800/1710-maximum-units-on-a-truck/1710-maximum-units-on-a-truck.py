# https://leetcode.com/problems/maximum-units-on-a-truck/

class Solution:
    def maximumUnits(self, boxTypes: list[list[int]], truckSize: int) -> int:
        boxTypes.sort(key=lambda x: -x[1])
        units = 0
        remaining = truckSize
        for count, per_box in boxTypes:
            take = min(count, remaining)
            units += take * per_box
            remaining -= take
            if remaining == 0:
                break
        return units
