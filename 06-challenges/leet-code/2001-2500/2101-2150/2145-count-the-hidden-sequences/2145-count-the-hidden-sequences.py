# https://leetcode.com/problems/count-the-hidden-sequences/
class Solution:
    def numberOfArrays(self, differences: List[int], lower: int, upper: int) -> int:
        prefix = 0
        min_val = 0
        max_val = 0
        for d in differences:
            prefix += d
            min_val = min(min_val, prefix)
            max_val = max(max_val, prefix)
        result = (upper - lower) - (max_val - min_val) + 1
        return max(result, 0)
