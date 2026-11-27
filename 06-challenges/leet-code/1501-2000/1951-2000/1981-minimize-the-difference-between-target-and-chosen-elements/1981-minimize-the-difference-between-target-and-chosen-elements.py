# https://leetcode.com/problems/minimize-the-difference-between-target-and-chosen-elements/

class Solution:
    def minimizeTheDifference(self, mat: List[List[int]], target: int) -> int:
        dp = {0}
        for row in mat:
            dp = {s + v for s in dp for v in row}
        return min(abs(s - target) for s in dp)
