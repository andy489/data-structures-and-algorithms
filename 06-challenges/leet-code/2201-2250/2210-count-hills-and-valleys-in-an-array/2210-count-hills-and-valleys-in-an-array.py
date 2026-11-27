# https://leetcode.com/problems/count-hills-and-valleys-in-an-array/
class Solution:
    def countHillValley(self, nums: List[int]) -> int:
        dedup = []
        for num in nums:
            if not dedup or dedup[-1] != num:
                dedup.append(num)
        count = 0
        for i in range(1, len(dedup) - 1):
            if dedup[i] > dedup[i - 1] and dedup[i] > dedup[i + 1]:
                count += 1
            elif dedup[i] < dedup[i - 1] and dedup[i] < dedup[i + 1]:
                count += 1
        return count
