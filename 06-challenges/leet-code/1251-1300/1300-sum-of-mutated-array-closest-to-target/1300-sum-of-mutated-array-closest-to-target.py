# https://leetcode.com/problems/sum-of-mutated-array-closest-to-target/

class Solution:
    def findBestValue(self, arr: list[int], target: int) -> int:
        arr.sort()
        lo, hi = 0, max(arr)
        best, best_diff = 0, float('inf')
        while lo <= hi:
            mid = (lo + hi) // 2
            s = sum(min(x, mid) for x in arr)
            diff = abs(s - target)
            if diff < best_diff or (diff == best_diff and mid < best):
                best_diff, best = diff, mid
            if s < target: lo = mid + 1
            else: hi = mid - 1
        return best
