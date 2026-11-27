# https://leetcode.com/problems/maximum-candies-allocated-to-k-children/
class Solution:
    def maximumCandies(self, candies: List[int], k: int) -> int:
        def can_allocate(m: int) -> bool:
            return sum(c // m for c in candies) >= k

        lo, hi = 1, max(candies)
        answer = 0
        while lo <= hi:
            mid = (lo + hi) // 2
            if can_allocate(mid):
                answer = mid
                lo = mid + 1
            else:
                hi = mid - 1
        return answer
