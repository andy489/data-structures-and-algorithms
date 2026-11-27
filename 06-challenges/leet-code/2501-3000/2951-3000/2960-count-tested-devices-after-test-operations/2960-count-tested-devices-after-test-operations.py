# https://leetcode.com/problems/count-tested-devices-after-test-operations/
class Solution:
    def countTestedDevices(self, batteryPercentages: list[int]) -> int:
        tested = 0
        for b in batteryPercentages:
            if b - tested > 0:
                tested += 1
        return tested
