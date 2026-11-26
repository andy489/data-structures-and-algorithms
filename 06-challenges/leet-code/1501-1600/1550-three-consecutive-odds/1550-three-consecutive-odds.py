# https://leetcode.com/problems/three-consecutive-odds/

class Solution:
    def threeConsecutiveOdds(self, arr: list[int]) -> bool:
        count = 0
        for x in arr:
            if x % 2 == 1:
                count += 1
                if count == 3:
                    return True
            else:
                count = 0
        return False
