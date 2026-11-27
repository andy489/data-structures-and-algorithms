# https://leetcode.com/problems/reordered-power-of-2/

class Solution:
    def reorderedPowerOf2(self, n: int) -> bool:
        target = sorted(str(n))
        return any(sorted(str(1 << i)) == target for i in range(30))
