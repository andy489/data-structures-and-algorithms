# https://leetcode.com/problems/maximum-fruits-harvested-after-at-most-k-steps/

# Solution: Sliding Window — O(n) time, O(1) extra space
class Solution:
    def maxTotalFruits(self, fruits: list[list[int]], startPos: int, k: int) -> int:
        def reachable(L, R):
            if R < startPos:
                return startPos - L <= k
            if L > startPos:
                return R - startPos <= k
            return (R - L) + min(startPos - L, R - startPos) <= k

        left = 0
        window_sum = 0
        result = 0

        for right in range(len(fruits)):
            window_sum += fruits[right][1]

            while left <= right and not reachable(fruits[left][0], fruits[right][0]):
                window_sum -= fruits[left][1]
                left += 1

            result = max(result, window_sum)

        return result
