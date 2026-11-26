# https://leetcode.com/problems/find-k-th-smallest-pair-distance/

class Solution:
    def smallestDistancePair(self, nums: List[int], k: int) -> int:
        nums.sort()
        n = len(nums)

        def count_pairs(dist):
            count, left = 0, 0
            for right in range(1, n):
                while nums[right] - nums[left] > dist:
                    left += 1
                count += right - left
            return count

        lo, hi = 0, nums[-1] - nums[0]
        while lo < hi:
            mid = (lo + hi) // 2
            if count_pairs(mid) >= k:
                hi = mid
            else:
                lo = mid + 1
        return lo
