# https://leetcode.com/problems/find-a-value-of-a-mysterious-function-closest-to-target/

class Solution:
    def closestToTarget(self, arr, target: int) -> int:
        ans = float('inf')
        cur = set()
        for x in arr:
            cur = {v & x for v in cur} | {x}
            for v in cur:
                ans = min(ans, abs(v - target))
        return ans
